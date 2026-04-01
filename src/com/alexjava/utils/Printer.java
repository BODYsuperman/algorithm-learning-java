package com.alexjava.utils;

import com.alexjava.common.structures.ListNode;

import java.util.*;
import java.util.function.Function;

/**
 * 格式化打印工具类
 * 支持数组、链表、矩阵等数据结构的可视化输出
 */
public class Printer {

    // ANSI 颜色代码（可选，用于终端美化）
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";

    /**
     * 打印标题
     */
    public static void title(String text) {
        title(text, 60, "=");
    }

    public static void title(String text, int width, String char_) {
        System.out.println();
        System.out.println(char_.repeat(width));
        System.out.println("  " + text);
        System.out.println(char_.repeat(width));
        System.out.println();
    }

    /**
     * 打印信息（带表情符号）
     */
    public static void info(String text) {
        System.out.println("📘 " + text);
    }

    public static void success(String text) {
        System.out.println(GREEN + "✅ " + text + RESET);
    }

    public static void error(String text) {
        System.out.println(RED + "❌ " + text + RESET);
    }

    public static void warning(String text) {
        System.out.println(YELLOW + "⚠️  " + text + RESET);
    }

    public static void step(String text) {
        System.out.println(CYAN + "🔹 " + text + RESET);
    }

    /**
     * 打印一维数组
     */
    public static void printArray(int[] arr) {
        printArray(arr, "Array");
    }

    public static void printArray(int[] arr, String name) {
        if (arr == null) {
            System.out.println(name + ": null");
            return;
        }
        System.out.print(name + " [" + arr.length + "]: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void printArray(Integer[] arr, String name) {
        if (arr == null) {
            System.out.println(name + ": null");
            return;
        }
        System.out.print(name + " [" + arr.length + "]: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static <T> void printArray(T[] arr, String name) {
        if (arr == null) {
            System.out.println(name + ": null");
            return;
        }
        System.out.print(name + " [" + arr.length + "]: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    /**
     * 打印二维数组（矩阵）
     */
    public static void printMatrix(int[][] matrix) {
        printMatrix(matrix, "Matrix");
    }

    public static void printMatrix(int[][] matrix, String name) {
        if (matrix == null) {
            System.out.println(name + ": null");
            return;
        }
        System.out.println(name + " [" + matrix.length + "x" +
                (matrix.length > 0 ? matrix[0].length : 0) + "]:");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("  ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%4d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 打印链表
     */
    public static void printListNode(ListNode head) {
        printListNode(head, "Linked List");
    }

    public static void printListNode(ListNode head, String name) {
        if (head == null) {
            System.out.println(name + ": null");
            return;
        }
        System.out.print(name + ": ");
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) {
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }

    /**
     * 打印列表
     */
    public static <T> void printList(List<T> list, String name) {
        if (list == null) {
            System.out.println(name + ": null");
            return;
        }
        System.out.print(name + " [" + list.size() + "]: ");
        System.out.println(list);
    }

    /**
     * 打印 Map
     */
    public static <K, V> void printMap(Map<K, V> map, String name) {
        if (map == null) {
            System.out.println(name + ": null");
            return;
        }
        System.out.println(name + " [" + map.size() + "]:");
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
    }

    /**
     * 打印算法执行步骤（带高亮）
     */
    public static void printStep(String step, int... highlightIndices) {
        System.out.print(CYAN + "  " + step + ": " + RESET);
        // 这里可以配合高亮索引打印数组片段
        System.out.println();
    }

    /**
     * 打印分隔线
     */
    public static void separator() {
        System.out.println(GREEN + "─".repeat(50) + RESET);
    }

    /**
     * 打印算法对比结果
     */
    public static void printComparison(String algorithm, long timeNanos, Object result) {
        System.out.printf("%-20s | %10d ns | %s%n",
                algorithm, timeNanos, result);
    }
}
