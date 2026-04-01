package com.alexjava.utils;

import com.alexjava.common.structures.ListNode;

import java.util.Arrays;

/**
 * 断言工具类
 * 用于算法实现中的快速验证
 */
public class Assertion {

    /**
     * 断言条件为真
     */
    public static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError("断言失败: " + message);
        }
    }

    public static void assertTrue(boolean condition) {
        assertTrue(condition, "");
    }

    /**
     * 断言两个整数相等
     */
    public static void assertEquals(int expected, int actual) {
        assertEquals(expected, actual, "");
    }

    public static void assertEquals(int expected, int actual, String message) {
        if (expected != actual) {
            throw new AssertionError(String.format(
                    "断言失败: 期望 %d, 实际 %d %s", expected, actual, message));
        }
    }

    /**
     * 断言两个数组相等
     */
    public static void assertArrayEquals(int[] expected, int[] actual) {
        if (!Arrays.equals(expected, actual)) {
            throw new AssertionError(String.format(
                    "数组不相等\n期望: %s\n实际: %s",
                    Arrays.toString(expected), Arrays.toString(actual)));
        }
    }

    /**
     * 断言链表相等
     */
    public static void assertListEquals(ListNode expected, ListNode actual) {
        ListNode p1 = expected, p2 = actual;
        int pos = 0;
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                throw new AssertionError(String.format(
                        "链表第 %d 个节点不相等: 期望 %d, 实际 %d", pos, p1.val, p2.val));
            }
            p1 = p1.next;
            p2 = p2.next;
            pos++;
        }
        if (p1 != null || p2 != null) {
            throw new AssertionError("链表长度不相等");
        }
    }

    /**
     * 验证排序结果
     */
    public static void verifySorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1]) {
                throw new AssertionError(String.format(
                        "排序失败: 位置 %d 和 %d: %d > %d", i-1, i, arr[i-1], arr[i]));
            }
        }
    }
}