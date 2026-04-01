package com.alexjava.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * 性能计时工具类
 * 支持单次计时、多次平均计时、多算法对比
 */
public class Timer {

    private long startTime;
    private String taskName;
    private static final Map<String, Stats> statsMap = new HashMap<>();

    public Timer() {
        this("");
    }

    public Timer(String taskName) {
        this.taskName = taskName;
        this.startTime = System.nanoTime();
    }

    /**
     * 开始计时
     */
    public void start() {
        start("");
    }

    public void start(String taskName) {
        this.taskName = taskName;
        this.startTime = System.nanoTime();
    }

    /**
     * 结束计时并打印
     */
    public long stop() {
        return stop(true);
    }

    public long stop(boolean print) {
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        if (print) {
            printDuration(duration);
        }

        return duration;
    }

    /**
     * 结束计时并记录统计
     */
    public long stopAndRecord() {
        long duration = stop(false);
        statsMap.computeIfAbsent(taskName, k -> new Stats())
                .addDuration(duration);
        return duration;
    }

    private void printDuration(long durationNanos) {
        double millis = durationNanos / 1_000_000.0;
        double micros = durationNanos / 1000.0;

        if (millis >= 1000) {
            System.out.printf("⏱️  %s: %.2f s%n", taskName, millis / 1000);
        } else if (millis >= 1) {
            System.out.printf("⏱️  %s: %.3f ms%n", taskName, millis);
        } else {
            System.out.printf("⏱️  %s: %.2f μs%n", taskName, micros);
        }
    }

    /**
     * 执行并计时
     */
    public static <T> TimedResult<T> time(String taskName, Supplier<T> task) {
        Timer timer = new Timer(taskName);
        T result = task.get();
        long duration = timer.stop(false);
        timer.printDuration(duration);
        return new TimedResult<>(result, duration);
    }

    /**
     * 执行多次并统计
     */
    public static <T> Stats timeMultiple(String taskName, Supplier<T> task, int iterations) {
        Stats stats = new Stats();
        Timer timer = new Timer();

        for (int i = 0; i < iterations; i++) {
            timer.start();
            task.get();
            stats.addDuration(timer.stop(false));
        }

        System.out.printf("📊 %s (%d次): 平均 %.3f ms, 最小 %.3f ms, 最大 %.3f ms%n",
                taskName, iterations,
                stats.getAverageMs(),
                stats.getMinMs(),
                stats.getMaxMs());

        return stats;
    }

    /**
     * 打印所有已记录的统计信息
     */
    public static void printStats() {
        Printer.title("性能统计");
        for (Map.Entry<String, Stats> entry : statsMap.entrySet()) {
            Stats stats = entry.getValue();
            System.out.printf("  %s: 平均 %.3f ms, 最小 %.3f ms, 最大 %.3f ms (共%d次)%n",
                    entry.getKey(),
                    stats.getAverageMs(),
                    stats.getMinMs(),
                    stats.getMaxMs(),
                    stats.getCount());
        }
    }

    /**
     * 计时结果封装
     */
    public static class TimedResult<T> {
        private final T result;
        private final long durationNanos;

        public TimedResult(T result, long durationNanos) {
            this.result = result;
            this.durationNanos = durationNanos;
        }

        public T getResult() { return result; }
        public long getDurationNanos() { return durationNanos; }
        public double getDurationMs() { return durationNanos / 1_000_000.0; }
    }

    /**
     * 统计信息类
     */
    public static class Stats {
        private long count = 0;
        private long totalNanos = 0;
        private long minNanos = Long.MAX_VALUE;
        private long maxNanos = 0;

        public void addDuration(long nanos) {
            count++;
            totalNanos += nanos;
            minNanos = Math.min(minNanos, nanos);
            maxNanos = Math.max(maxNanos, nanos);
        }

        public long getCount() { return count; }
        public double getAverageMs() { return (totalNanos / 1_000_000.0) / count; }
        public double getMinMs() { return minNanos / 1_000_000.0; }
        public double getMaxMs() { return maxNanos / 1_000_000.0; }
    }
}