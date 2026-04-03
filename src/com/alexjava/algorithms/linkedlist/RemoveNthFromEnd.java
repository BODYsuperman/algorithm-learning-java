package com.alexjava.algorithms.linkedlist;

import com.alexjava.common.structures.ListNode;

public class RemoveNthFromEnd {



    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyNode = new ListNode(0, head);

        ListNode fastIndex = dummyNode;
        ListNode slowIndex = dummyNode;

        for (int i = 0; i <= n; i++) {
            fastIndex = fastIndex.next;
        }

        while (fastIndex != null) {
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
        }

        // 此时 slowIndex 的位置就是待删除元素的前一个位置。
        // 具体情况可自己画一个链表长度为 3 的图来模拟代码来理解
        // 检查 slowIndex.next 是否为 null，以避免空指针异常
        if (slowIndex.next != null) {
            slowIndex.next = slowIndex.next.next;
        }
        return dummyNode.next;

    }
}
