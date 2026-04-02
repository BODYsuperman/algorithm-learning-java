package com.alexjava.algorithms.linkedlist;

import com.alexjava.common.structures.ListNode;
import com.alexjava.utils.*;

public class SwapPairs {

    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null){
            ListNode node1 = cur.next;
            ListNode node2 = cur.next.next;

            cur.next = node2;
            node1.next = node2.next;
            node2.next = node1;

            cur = cur.next.next;

        }

        return  dummy.next;


    }

    public static void main(String[] args) {
        SwapPairs solution = new SwapPairs();

        // 1. 基本功能测试
        testBasicCases(solution);

        // 2. 可视化测试（修复后）
        testVisualization(solution);

        // 3. 边界情况测试
        testEdgeCases(solution);

        // 4. 性能测试
        testPerformance(solution);
    }

    /**
     * 测试基本用例
     */
    private static void testBasicCases(SwapPairs solution) {
        Printer.title("两两交换链表节点 - 基本功能测试");

        // 测试用例1: 偶数个节点
        Printer.step("测试1: 偶数个节点 (1->2->3->4)");
        ListNode head1 = ListNode.of(1, 2, 3, 4);
        Printer.printListNode(head1, "原始链表");

        ListNode result1 = solution.swapPairs(head1);
        Printer.printListNode(result1, "交换后");

        ListNode expected1 = ListNode.of(2, 1, 4, 3);
        if (result1 != null && result1.equals(expected1)) {
            Printer.success("✅ 测试1通过");
        } else {
            Printer.error("❌ 测试1失败");
        }
        Printer.separator();

        // 测试用例2: 奇数个节点
        Printer.step("测试2: 奇数个节点 (1->2->3->4->5)");
        ListNode head2 = ListNode.of(1, 2, 3, 4, 5);
        Printer.printListNode(head2, "原始链表");

        ListNode result2 = solution.swapPairs(head2);
        Printer.printListNode(result2, "交换后");

        ListNode expected2 = ListNode.of(2, 1, 4, 3, 5);
        if (result2 != null && result2.equals(expected2)) {
            Printer.success("✅ 测试2通过");
        } else {
            Printer.error("❌ 测试2失败");
        }
        Printer.separator();
    }

    /**
     * 可视化测试（修复版）
     */
    private static void testVisualization(SwapPairs solution) {
        Printer.title("交换过程可视化");

        Printer.info("原始链表: 1 -> 2 -> 3 -> 4 -> 5 -> 6\n");

        // 手动模拟交换过程
        ListNode dummy = new ListNode(0);
        ListNode head = ListNode.of(1, 2, 3, 4, 5, 6);
        dummy.next = head;

        ListNode cur = dummy;
        int step = 1;

        System.out.println("初始状态:");
        printListWithPointer(dummy.next, cur, "cur指向dummy（虚拟头节点）");
        System.out.println();

        while (cur.next != null && cur.next.next != null) {
            System.out.println("第 " + step + " 轮交换:");

            ListNode node1 = cur.next;
            ListNode node2 = cur.next.next;

            System.out.println("  准备交换: " + node1.val + " 和 " + node2.val);

            // 执行交换
            cur.next = node2;
            node1.next = node2.next;
            node2.next = node1;

            System.out.println("  交换完成: " + node2.val + " <-> " + node1.val);

            // 移动到下一对
            cur = cur.next.next;

            System.out.print("  当前链表: ");
            printListSimple(dummy.next);
            System.out.println("  cur指向节点: " + (cur != null && cur.val != 0 ? cur.val : "null"));
            System.out.println();

            step++;
        }

        Printer.success("✅ 最终结果: ");
        printListSimple(dummy.next);
        Printer.separator();
    }

    /**
     * 测试边界情况
     */
    private static void testEdgeCases(SwapPairs solution) {
        Printer.title("边界情况测试");

        // 测试1: 空链表
        Printer.step("测试1: 空链表");
        ListNode head1 = null;
        ListNode result1 = solution.swapPairs(head1);
        if (result1 == null) {
            Printer.success("✅ 空链表测试通过");
        } else {
            Printer.error("❌ 空链表测试失败");
        }
        Printer.separator();

        // 测试2: 单个节点
        Printer.step("测试2: 单个节点");
        ListNode head2 = ListNode.of(1);
        ListNode result2 = solution.swapPairs(head2);
        if (result2 != null && result2.val == 1 && result2.next == null) {
            Printer.success("✅ 单节点测试通过");
        } else {
            Printer.error("❌ 单节点测试失败");
        }
        Printer.separator();

        // 测试3: 两个节点
        Printer.step("测试3: 两个节点 (1->2)");
        ListNode head3 = ListNode.of(1, 2);
        ListNode result3 = solution.swapPairs(head3);
        ListNode expected3 = ListNode.of(2, 1);
        if (result3 != null && result3.equals(expected3)) {
            Printer.success("✅ 两节点测试通过");
        } else {
            Printer.error("❌ 两节点测试失败");
        }
        Printer.separator();
    }

    /**
     * 性能测试
     */
    private static void testPerformance(SwapPairs solution) {
        Printer.title("性能测试");

        int[] sizes = {1000, 10000, 100000};

        for (int size : sizes) {
            Printer.info("测试规模: " + size + " 个节点");

            // 构建链表
            ListNode head = null;
            for (int i = size; i >= 1; i--) {
                head = new ListNode(i, head);
            }

            final ListNode finalHead = head;
            Timer.time("交换 " + size + " 个节点", () -> {
                solution.swapPairs(finalHead);
                return null;
            });

            Printer.separator();
        }

        // 多次测试取平均值
        Printer.info("多次测试取平均值 (100次)");
        int testSize = 10000;
        Timer.timeMultiple("两两交换 (size=" + testSize + ")", () -> {
            ListNode testHead = null;
            for (int i = testSize; i >= 1; i--) {
                testHead = new ListNode(i, testHead);
            }
            solution.swapPairs(testHead);
            return null;
        }, 100);

        Timer.printStats();
    }

    /**
     * 修复后的打印方法（带指针位置）
     */
    private static void printListWithPointer(ListNode head, ListNode pointer, String pointerDesc) {
        if (head == null) {
            System.out.println("空链表");
            return;
        }

        // 收集所有节点值
        java.util.ArrayList<Integer> values = new java.util.ArrayList<>();
        java.util.ArrayList<ListNode> nodes = new java.util.ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            values.add(cur.val);
            nodes.add(cur);
            cur = cur.next;
        }

        // 打印链表
        for (int i = 0; i < values.size(); i++) {
            System.out.print(values.get(i));
            if (i < values.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();

        // 找到指针位置
        int pointerIndex = -1;
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i) == pointer) {
                pointerIndex = i;
                break;
            }
        }

        // 打印指针指示
        if (pointerIndex >= 0) {
            // 计算箭头位置
            StringBuilder arrow = new StringBuilder();
            for (int i = 0; i < pointerIndex; i++) {
                // 每个数字和" -> "的宽度估算
                String numStr = String.valueOf(values.get(i));
                arrow.append(" ".repeat(numStr.length()));
                if (i < values.size() - 1) {
                    arrow.append("    "); // " -> " 的宽度
                }
            }

            // 在当前数字位置添加箭头
            String numStr = String.valueOf(values.get(pointerIndex));
            arrow.append("↑");
            arrow.append(" ".repeat(Math.max(0, numStr.length() - 1)));

            System.out.println(arrow.toString() + " " + pointerDesc);
        } else if (pointer != null && pointer.val == 0) {
            // 虚拟头节点的情况
            System.out.println("↑ cur指向dummy（虚拟头节点，在链表前面）");
        }
    }

    /**
     * 简单打印链表
     */
    private static void printListSimple(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }

        StringBuilder sb = new StringBuilder();
        ListNode cur = head;
        while (cur != null) {
            sb.append(cur.val);
            if (cur.next != null) {
                sb.append(" -> ");
            }
            cur = cur.next;
        }
        System.out.println(sb.toString());
    }

    /**
     * 辅助方法：打印链表（用于调试）
     */
    private static void printList(String title, ListNode head) {
        System.out.print(title + ": ");
        printListSimple(head);
    }
}
