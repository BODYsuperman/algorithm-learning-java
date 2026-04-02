package com.alexjava.algorithms.linkedlist;

import com.alexjava.common.structures.ListNode;
import com.alexjava.utils.Printer;
import com.alexjava.utils.Timer;

import java.sql.ClientInfoStatus;

public class RemoveElements {

    public static void main(String[] args) {
        RemoveElements solution = new RemoveElements();

        // 1. 基本测试
        testBasicCases(solution);

        // 2. 性能测试
        testPerformance(solution);
    }

    private static void testBasicCases(RemoveElements solution) {
        Printer.title("移除链表元素 - 基本功能测试");

        // 测试用例 1: 删除中间节点
        ListNode head1 = ListNode.of(1, 2, 6, 3, 4, 5, 6);
        Printer.printListNode(head1, "测试1 - 原始链表");
        Printer.info("删除值: 6");

        ListNode result1 = solution.removeElements(head1, 6);
        Printer.printListNode(result1, "结果链表");

        // 验证
        ListNode expected1 = ListNode.of(1, 2, 3, 4, 5);
        if (result1 != null && result1.equals(expected1)) {
            Printer.success("✅ 测试1通过");
        } else {
            Printer.error("❌ 测试1失败");
        }
        Printer.separator();

        // 测试用例 2: 删除头节点
        ListNode head2 = ListNode.of(7, 7, 7, 8, 9);
        Printer.printListNode(head2, "测试2 - 原始链表");
        Printer.info("删除值: 7");

        ListNode result2 = solution.removeElements(head2, 7);
        Printer.printListNode(result2, "结果链表");

        ListNode expected2 = ListNode.of(8, 9);
        if (result2 != null && result2.equals(expected2)) {
            Printer.success("✅ 测试2通过");
        } else {
            Printer.error("❌ 测试2失败");
        }
        Printer.separator();

        // 测试用例 3: 删除尾节点
        ListNode head3 = ListNode.of(1, 2, 3, 4, 5);
        Printer.printListNode(head3, "测试3 - 原始链表");
        Printer.info("删除值: 5");

        ListNode result3 = solution.removeElements(head3, 5);
        Printer.printListNode(result3, "结果链表");

        ListNode expected3 = ListNode.of(1, 2, 3, 4);
        if (result3 != null && result3.equals(expected3)) {
            Printer.success("✅ 测试3通过");
        } else {
            Printer.error("❌ 测试3失败");
        }
        Printer.separator();

        // 测试用例 4: 空链表
        ListNode head4 = null;
        Printer.info("测试4 - 空链表");

        ListNode result4 = solution.removeElements(head4, 1);
        if (result4 == null) {
            Printer.success("✅ 测试4通过");
        } else {
            Printer.error("❌ 测试4失败");
        }

        Printer.separator();
    }

    private static void testPerformance(RemoveElements solution) {
        Printer.title("性能测试");

        int[] sizes = {1000, 10000, 100000};

        for (int size : sizes) {
            Printer.info("测试规模: " + size + " 个节点");

            // 构建链表
            ListNode head = null;
            for (int i = size; i >= 1; i--) {
                head = new ListNode(i, head);
            }

            int targetVal = size / 2;

            // 创建 effectively final 的副本
            final ListNode finalHead = head;
            final int finalTargetVal = targetVal;

            Timer.time("删除 " + targetVal, () -> {
                solution.removeElements(finalHead, finalTargetVal);
                return null;
            });
        }
    }

    public ListNode removeElements(ListNode head, int val) {


        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode cur = dummy;
        while (cur.next != null){
            if(cur.next.val == val){
                //target node we want to remove
                cur.next = cur.next.next;
            }
            else{
                //move to the next node keep going
                cur = cur.next;
            }
        }

        return dummy.next;

    }
}
