package com.alexjava.algorithms.binarytree;

public class RemoveElements {
    public static void main(String[] args) {

        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(6,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5,
                                                        new ListNode(6)))))));

        int val = 6;

        ListNode res = removeElements(head, val);
        System.out.println(res.toString());
    }

    public static ListNode removeElements(ListNode head, int val) {
        //dummy head
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode cur = dummy;
        while (cur.next!=null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }
            else{
                cur = cur.next;
            }
        }
        return dummy.next;

    }
}
