package com.alexjava.algorithms.linkedlist;

import com.alexjava.common.structures.ListNode;
import com.alexjava.utils.*;

public class ReverseList {



    public ListNode reverseList(ListNode head){


        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;

        while (cur!=null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


    public static void main(String[] args) {
        ReverseList solution = new ReverseList();

        // 1. 基本功能测试
        testBasicCases(solution);

        // 2. 边界情况测试
        testEdgeCases(solution);

        // 3. 可视化测试
        testVisualization(solution);

        // 4. 性能测试
        testPerformance(solution);

        // 5. 批量测试
        testBatchCases(solution);
    }

    /**
     * 测试基本用例
     */
    private static void testBasicCases(ReverseList solution) {
        Printer.title("反转链表 - 基本功能测试");

        // 测试用例1: 正常链表
        ListNode head1 = ListNode.of(1, 2, 3, 4, 5);
        Printer.printListNode(head1, "原始链表");

        ListNode reversed1 = solution.reverseList(head1);
        Printer.printListNode(reversed1, "反转后");

        // 验证结果
        ListNode expected1 = ListNode.of(5, 4, 3, 2, 1);
        if (reversed1 != null && reversed1.equals(expected1)) {
            Printer.success("✅ 测试1通过");
        } else {
            Printer.error("❌ 测试1失败");
        }
        Printer.separator();

        // 测试用例2: 两个节点
        ListNode head2 = ListNode.of(1, 2);
        Printer.printListNode(head2, "原始链表");

        ListNode reversed2 = solution.reverseList(head2);
        Printer.printListNode(reversed2, "反转后");

        ListNode expected2 = ListNode.of(2, 1);
        if (reversed2 != null && reversed2.equals(expected2)) {
            Printer.success("✅ 测试2通过");
        } else {
            Printer.error("❌ 测试2失败");
        }
        Printer.separator();

        // 测试用例3: 单个节点
        ListNode head3 = ListNode.of(1);
        Printer.printListNode(head3, "原始链表");

        ListNode reversed3 = solution.reverseList(head3);
        Printer.printListNode(reversed3, "反转后");

        ListNode expected3 = ListNode.of(1);
        if (reversed3 != null && reversed3.equals(expected3)) {
            Printer.success("✅ 测试3通过");
        } else {
            Printer.error("❌ 测试3失败");
        }
        Printer.separator();
    }

    /**
     * 测试边界情况
     */
    private static void testEdgeCases(ReverseList solution) {
        Printer.title("边界情况测试");

        // 测试用例4: 空链表
        Printer.step("测试空链表");
        ListNode head4 = null;
        Printer.printListNode(head4, "原始链表");

        ListNode reversed4 = solution.reverseList(head4);
        Printer.printListNode(reversed4, "反转后");

        if (reversed4 == null) {
            Printer.success("✅ 空链表测试通过");
        } else {
            Printer.error("❌ 空链表测试失败");
        }
        Printer.separator();

        // 测试用例5: 两个相同值的节点
        Printer.step("测试相同值节点");
        ListNode head5 = ListNode.of(1, 1, 1);
        Printer.printListNode(head5, "原始链表");

        ListNode reversed5 = solution.reverseList(head5);
        Printer.printListNode(reversed5, "反转后");

        ListNode expected5 = ListNode.of(1, 1, 1);
        if (reversed5 != null && reversed5.equals(expected5)) {
            Printer.success("✅ 相同值测试通过");
        } else {
            Printer.error("❌ 相同值测试失败");
        }
        Printer.separator();

        // 测试用例6: 长链表
        Printer.step("测试长链表");
        ListNode head6 = ListNode.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Printer.printListNode(head6, "原始链表");

        ListNode reversed6 = solution.reverseList(head6);
        Printer.printListNode(reversed6, "反转后");

        ListNode expected6 = ListNode.of(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
        if (reversed6 != null && reversed6.equals(expected6)) {
            Printer.success("✅ 长链表测试通过");
        } else {
            Printer.error("❌ 长链表测试失败");
        }
        Printer.separator();
    }

    /**
     * 可视化测试（逐步显示反转过程）
     */
    private static void testVisualization(ReverseList solution) {
        Printer.title("反转过程可视化");

        Printer.info("原始链表: 1 -> 2 -> 3 -> 4 -> 5");
        Printer.info("\n反转步骤:");

        // 手动模拟反转过程
        ListNode head = ListNode.of(1, 2, 3, 4, 5);

        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        int step = 1;

        while (cur != null) {
            Printer.step("步骤 " + step++);
            Printer.info("  当前节点 cur = " + cur.val);
            Printer.info("  前驱节点 pre = " + (pre != null ? pre.val : "null"));

            temp = cur.next;
            Printer.info("  保存下一个节点 temp = " + (temp != null ? temp.val : "null"));

            cur.next = pre;
            Printer.info("  反转指针: " + cur.val + ".next -> " + (pre != null ? pre.val : "null"));

            pre = cur;
            Printer.info("  移动 pre 到 " + pre.val);

            cur = temp;
            Printer.info("  移动 cur 到 " + (cur != null ? cur.val : "null"));

            // 打印当前反转的部分链表
            System.out.print("  当前反转部分: ");
            ListNode printNode = pre;
            while (printNode != null) {
                System.out.print(printNode.val);
                if (printNode.next != null) System.out.print(" -> ");
                printNode = printNode.next;
            }
            System.out.println();
            System.out.println();
        }

        Printer.success("✅ 反转完成！最终结果: 5 -> 4 -> 3 -> 2 -> 1");
        Printer.separator();
    }

    /**
     * 性能测试
     */
    private static void testPerformance(ReverseList solution) {
        Printer.title("性能测试");

        int[] sizes = {1000, 10000, 100000, 1000000};

        for (int size : sizes) {
            Printer.info("测试规模: " + size + " 个节点");

            // 构建链表
            ListNode head = null;
            for (int i = size; i >= 1; i--) {
                head = new ListNode(i, head);
            }

            // 单次测试
            final ListNode finalHead = head;
            Timer.time("反转 " + size + " 个节点", () -> {
                solution.reverseList(finalHead);
                return null;
            });

            Printer.separator();
        }

        // 多次测试取平均值
        Printer.info("多次测试取平均值 (100次)");
        int testSize = 10000;
        Timer.timeMultiple("反转链表 (size=" + testSize + ")", () -> {
            // 每次重新构建链表
            ListNode testHead = null;
            for (int i = testSize; i >= 1; i--) {
                testHead = new ListNode(i, testHead);
            }
            solution.reverseList(testHead);
            return null;
        }, 100);

        Timer.printStats();
    }

    /**
     * 批量测试
     */
    private static void testBatchCases(ReverseList solution) {
        Printer.title("批量测试");

        // 准备测试数据
        ListNode[] inputs = {
                ListNode.of(1, 2, 3, 4, 5),
                ListNode.of(1, 2),
                ListNode.of(1),
                null,
                ListNode.of(1, 2, 3),
                ListNode.of(5, 4, 3, 2, 1),
                ListNode.of(1, 1, 2, 2)
        };

        ListNode[] expecteds = {
                ListNode.of(5, 4, 3, 2, 1),
                ListNode.of(2, 1),
                ListNode.of(1),
                null,
                ListNode.of(3, 2, 1),
                ListNode.of(1, 2, 3, 4, 5),
                ListNode.of(2, 2, 1, 1)
        };

        String[] testNames = {
                "测试1: 5个节点",
                "测试2: 2个节点",
                "测试3: 1个节点",
                "测试4: 空链表",
                "测试5: 3个节点",
                "测试6: 反转两次应回原样",
                "测试7: 有重复值"
        };

        int passed = 0;
        int failed = 0;

        for (int i = 0; i < inputs.length; i++) {
            Printer.step(testNames[i]);
            Printer.printListNode(inputs[i], "输入");

            // 注意：反转会修改原链表，所以需要复制
            ListNode inputCopy = copyList(inputs[i]);
            ListNode result = solution.reverseList(inputCopy);
            Printer.printListNode(result, "输出");

            // 验证
            boolean isEqual = compareLists(result, expecteds[i]);
            if (isEqual) {
                Printer.success("✅ 通过");
                passed++;
            } else {
                Printer.error("❌ 失败");
                Printer.printListNode(expecteds[i], "期望");
                failed++;
            }
            Printer.separator();
        }

        // 打印总结
        Printer.title("测试总结");
        Printer.info("总计: " + (passed + failed) + " 个测试");
        Printer.success("通过: " + passed);
        if (failed > 0) {
            Printer.error("失败: " + failed);
        } else {
            Printer.success("🎉 所有测试通过！");
        }
    }

    /**
     * 复制链表（用于测试，避免修改原链表）
     */
    private static ListNode copyList(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        ListNode original = head;

        while (original != null) {
            current.next = new ListNode(original.val);
            current = current.next;
            original = original.next;
        }

        return dummy.next;
    }

    /**
     * 比较两个链表是否相等
     */
    private static boolean compareLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;

        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1 == null && p2 == null;
    }


}
