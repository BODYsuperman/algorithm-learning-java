package com.alexjava.utils;

import com.alexjava.common.structures.ListNode;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 测试数据生成器
 * 用于生成各种类型的测试数据
 */
public class DataGenerator {

    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    /**
     * 生成随机整数数组
     */
    public static int[] randomIntArray(int size, int min, int max) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(min, max + 1);
        }
        return arr;
    }

    /**
     * 生成近乎有序的数组（用于测试排序算法）
     */
    public static int[] nearlySortedArray(int size, int swapTimes) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < swapTimes; i++) {
            int idx1 = random.nextInt(size);
            int idx2 = random.nextInt(size);
            int temp = arr[idx1];
            arr[idx1] = arr[idx2];
            arr[idx2] = temp;
        }

        return arr;
    }

    /**
     * 生成已排序数组
     */
    public static int[] sortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    /**
     * 生成逆序数组
     */
    public static int[] reversedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }
        return arr;
    }

    /**
     * 生成包含重复元素的数组
     */
    public static int[] arrayWithDuplicates(int size, int uniqueCount) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(uniqueCount);
        }
        return arr;
    }

    /**
     * 生成随机字符串数组
     */
    public static String[] randomStringArray(int size, int stringLength) {
        String[] arr = new String[size];
        String chars = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < size; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < stringLength; j++) {
                sb.append(chars.charAt(random.nextInt(chars.length())));
            }
            arr[i] = sb.toString();
        }
        return arr;
    }

    /**
     * 生成随机矩阵
     */
    public static int[][] randomMatrix(int rows, int cols, int min, int max) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(min, max + 1);
            }
        }
        return matrix;
    }

    /**
     * 生成随机链表
     */
    public static ListNode randomListNode(int size, int min, int max) {
        if (size == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int i = 0; i < size; i++) {
            curr.next = new ListNode(random.nextInt(min, max + 1));
            curr = curr.next;
        }
        return dummy.next;
    }

    /**
     * 生成随机列表
     */
    public static List<Integer> randomList(int size, int min, int max) {
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(min, max + 1));
        }
        return list;
    }
}