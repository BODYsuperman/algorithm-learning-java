package com.alexjava.algorithms.binarytree;

import javax.swing.*;

public class MyLinkedList {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        // addAtHead
        list.addAtHead(1);   // 1
        list.addAtHead(2);   // 2 -> 1
        System.out.print("addAtHead 后: ");
        list.print(list.head);

        // addAtTail
        list.addAtTail(3);   // 2 -> 1 -> 3
        list.addAtTail(4);   // 2 -> 1 -> 3 -> 4
        System.out.print("addAtTail 后: ");
        list.print(list.head);

        // get
        System.out.println("get(0): " + list.get(0)); // 2
        System.out.println("get(2): " + list.get(2)); // 3
        System.out.println("get(5): " + list.get(5)); // -1

        // addAtIndex
        list.addAtIndex(2, 99); // 2 -> 1 -> 99 -> 3 -> 4
        System.out.print("addAtIndex(2,99): ");
        list.print(list.head);

        // deleteAtIndex
        list.deleteAtIndex(1); // 删除 1
        System.out.print("deleteAtIndex(1): ");
        list.print(list.head);

        list.deleteAtIndex(0); // 删除 2
        System.out.print("deleteAtIndex(0): ");
        list.print(list.head);
    }
    private  int size;
    //dummy head in order to manipulate easily
    private ListNode head;
    public MyLinkedList(){
        this.size = 0;
        this.head = new ListNode(0);
    }

    public int get(int index){
        if(index < 0 || index >= size){
            return -1;
        }
        ListNode cur = head;
        for (int i = 0; i <= index ; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val){
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        head.next = newNode;
        size++;
    }

    public void addAtTail(int val){
        ListNode newNode = new ListNode(val);
        ListNode cur = head;
        while (cur.next!=null){
            cur = cur.next;
        }
        cur.next = newNode;
        size++;
    }

    public void addAtIndex(int index , int val) {
        if (index < 0 || index >= size){
            return;
        }
        ListNode pre = head;
        for (int i = 0; i < index ; i++) {
            pre = pre.next;
        }

        ListNode newNode = new ListNode(val);
        newNode.next = pre.next;
        pre.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index ) {
        if (index < 0 || index >= size) {
            return;
        }

        ListNode pre = head;
        for (int i = 0; i < index ; i++) {
            pre = pre.next;
        }

        pre.next = pre.next.next;
        size--;
    }

    public static void print(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val);
            if (cur.next != null) {
                System.out.print(" -> ");
            }
            cur = cur.next;
        }
        System.out.println();
    }


}
