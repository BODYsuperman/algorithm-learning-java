package com.alexjava.utils;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.BiFunction;

/**
 * 算法测试框架
 * 支持输入输出验证、批量测试
 */
public class Tester {

    /**
     * 测试单个输入输出
     */
    public static <T, R> void test(String testName,
                                   T input,
                                   R expected,
                                   Function<T, R> algorithm) {
        System.out.println("\n🔍 测试: " + testName);
        Printer.info("输入: " + input);
        Printer.info("期望: " + expected);

        Timer timer = new Timer(testName);
        R actual = algorithm.apply(input);
        long duration = timer.stop(false);

        boolean passed = compare(expected, actual);

        if (passed) {
            Printer.success("通过 ✅ (耗时: " + formatDuration(duration) + ")");
        } else {
            Printer.error("失败 ❌");
            System.out.println("  实际: " + actual);
            System.out.println("  期望: " + expected);
        }
    }

    /**
     * 测试两个参数的算法
     */
    public static <T, U, R> void test(String testName,
                                      T input1,
                                      U input2,
                                      R expected,
                                      BiFunction<T, U, R> algorithm) {
        System.out.println("\n🔍 测试: " + testName);
        Printer.info("输入1: " + input1);
        Printer.info("输入2: " + input2);
        Printer.info("期望: " + expected);

        Timer timer = new Timer(testName);
        R actual = algorithm.apply(input1, input2);
        long duration = timer.stop(false);

        boolean passed = compare(expected, actual);

        if (passed) {
            Printer.success("通过 ✅ (耗时: " + formatDuration(duration) + ")");
        } else {
            Printer.error("失败 ❌");
            System.out.println("  实际: " + actual);
            System.out.println("  期望: " + expected);
        }
    }

    /**
     * 批量测试
     */
    public static <T, R> void testBatch(String algorithmName,
                                        T[] inputs,
                                        R[] expecteds,
                                        Function<T, R> algorithm) {
        if (inputs.length != expecteds.length) {
            Printer.error("测试数据数量不匹配");
            return;
        }

        Printer.title(algorithmName + " 批量测试");
        int passed = 0;
        long totalTime = 0;

        for (int i = 0; i < inputs.length; i++) {
            Timer timer = new Timer();
            R actual = algorithm.apply(inputs[i]);
            long duration = timer.stop(false);
            totalTime += duration;

            boolean testPassed = compare(expecteds[i], actual);
            if (testPassed) {
                passed++;
                System.out.print("✅ ");
            } else {
                System.out.print("❌ ");
            }
            System.out.printf("测试%d: 期望=%s, 实际=%s%n",
                    i + 1, expecteds[i], actual);
        }

        System.out.printf("\n📈 结果: %d/%d 通过, 总耗时 %.3f ms%n",
                passed, inputs.length, totalTime / 1_000_000.0);
    }

    /**
     * 对比多个算法
     */
    public static <T, R> void compareAlgorithms(String testName,
                                                T input,
                                                R expected,
                                                @SuppressWarnings("unchecked")
                                                Pair<String, Function<T, R>>... algorithms) {
        Printer.title(testName);
        Printer.info("输入: " + input);
        Printer.info("期望: " + expected);
        Printer.separator();

        for (Pair<String, Function<T, R>> pair : algorithms) {
            Timer timer = new Timer(pair.first);
            R actual = pair.second.apply(input);
            long duration = timer.stop(false);

            boolean passed = compare(expected, actual);
            System.out.printf("  %s: %s (耗时: %s)%n",
                    pair.first,
                    passed ? "✅ 通过" : "❌ 失败",
                    formatDuration(duration));
        }
    }

    /**
     * 比较两个对象是否相等（支持数组）
     */
    @SuppressWarnings("unchecked")
    private static <T> boolean compare(T expected, T actual) {
        if (expected == null && actual == null) return true;
        if (expected == null || actual == null) return false;

        // 处理数组类型
        if (expected.getClass().isArray() && actual.getClass().isArray()) {
            return compareArrays(expected, actual);
        }

        return expected.equals(actual);
    }

    private static boolean compareArrays(Object arr1, Object arr2) {
        if (arr1 instanceof int[] && arr2 instanceof int[]) {
            return Arrays.equals((int[]) arr1, (int[]) arr2);
        }
        if (arr1 instanceof Integer[] && arr2 instanceof Integer[]) {
            return Arrays.equals((Integer[]) arr1, (Integer[]) arr2);
        }
        if (arr1 instanceof int[][] && arr2 instanceof int[][]) {
            return Arrays.deepEquals((int[][]) arr1, (int[][]) arr2);
        }
        return arr1.equals(arr2);
    }

    private static String formatDuration(long nanos) {
        double millis = nanos / 1_000_000.0;
        if (millis >= 1000) {
            return String.format("%.2f s", millis / 1000);
        } else if (millis >= 1) {
            return String.format("%.3f ms", millis);
        } else {
            return String.format("%.2f μs", nanos / 1000.0);
        }
    }

    /**
     * 简单 Pair 类
     */
    public static class Pair<A, B> {
        public final A first;
        public final B second;

        public Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }

        public static <A, B> Pair<A, B> of(A first, B second) {
            return new Pair<>(first, second);
        }
    }
}