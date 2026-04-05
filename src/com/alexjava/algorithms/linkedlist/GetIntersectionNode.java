package com.alexjava.algorithms.linkedlist;

import com.alexjava.common.structures.ListNode;

public class GetIntersectionNode {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {


        ListNode p1 = headA, p2 = headB;

        while (p1 != p2){
            if(p1 == null) p1 = headB;
            else  p1 = p1.next;

            if(p2 == null) p2 = headA;
            else  p2 = p2.next;
        }

        return p1;
    }
}
