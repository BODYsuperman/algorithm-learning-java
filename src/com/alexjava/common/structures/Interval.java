package com.alexjava.common.structures;

import java.util.Objects;

/**
 * 区间数据结构（常用于合并区间、插入区间等问题）
 */
public class Interval implements Comparable<Interval> {

    private int start;
    private int end;

    public Interval() {}

    public Interval(int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException("start must <= end");
        }
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    /**
     * 获取区间长度
     */
    public int length() {
        return end - start;
    }

    /**
     * 判断两个区间是否相交
     */
    public boolean overlaps(Interval other) {
        return !(this.end < other.start || other.end < this.start);
    }

    /**
     * 合并两个区间（假设它们相交）
     */
    public Interval merge(Interval other) {
        return new Interval(
                Math.min(this.start, other.start),
                Math.max(this.end, other.end)
        );
    }

    /**
     * 判断是否包含某个点
     */
    public boolean contains(int point) {
        return start <= point && point <= end;
    }

    @Override
    public int compareTo(Interval other) {
        int startCompare = Integer.compare(this.start, other.start);
        if (startCompare != 0) {
            return startCompare;
        }
        return Integer.compare(this.end, other.end);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Interval)) return false;
        Interval interval = (Interval) o;
        return start == interval.start && end == interval.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}