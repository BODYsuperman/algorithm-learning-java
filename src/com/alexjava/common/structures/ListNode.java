package com.alexjava.common.structures;

import java.util.Objects;

/**
 * 单链表节点定义
 * 包含常用的静态工厂方法和工具方法
 */
public class ListNode {

    public int val;
    public ListNode next;

    // 构造函数
    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 从数组构建链表
     * 使用方式: ListNode.of(1, 2, 3, 4, 5)
     */
    public static ListNode of(int... values) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    /**
     * 从数组构建链表（支持 Integer 对象）
     */
    public static ListNode of(Integer[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (Integer val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    /**
     * 将链表转换为数组
     */
    public int[] toArray() {
        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
        ListNode current = this;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    /**
     * 获取链表长度
     */
    public int length() {
        int len = 0;
        ListNode current = this;
        while (current != null) {
            len++;
            current = current.next;
        }
        return len;
    }

    /**
     * 获取链表最后一个节点
     */
    public ListNode getTail() {
        ListNode current = this;
        while (current != null && current.next != null) {
            current = current.next;
        }
        return current;
    }

    /**
     * 在链表末尾添加节点
     */
    public ListNode append(int val) {
        ListNode tail = getTail();
        tail.next = new ListNode(val);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode current = this;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ListNode)) return false;

        ListNode other = (ListNode) obj;
        ListNode p1 = this;
        ListNode p2 = other;

        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1 == null && p2 == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
