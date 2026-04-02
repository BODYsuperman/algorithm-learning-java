package com.alexjava.algorithms.linkedlist;

import com.alexjava.common.structures.ListNode;

public class MyLinkedList {


    private  int size;

    private ListNode dummyHead;

    public MyLinkedList(){
        this.size = 0;
        this.dummyHead = new ListNode(0);
    }


    public int get(int index) {
        if(index < 0 || index >= size ){
            return  -1;
        }

        ListNode cur = dummyHead;
        for (int i = 0; i <= index ; i++) {

            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {

        ListNode newNode = new ListNode(val);
        newNode.next = dummyHead.next;
        dummyHead.next = newNode;
        size++;
    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);

        ListNode cur = dummyHead;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = newNode;
        size++;

    }

    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size ){
            return;
        }

        ListNode pre = dummyHead;
        for (int i = 0; i < index ; i++) {
            pre = pre.next;
        }

        ListNode newNode = new ListNode(val);
        newNode.next = pre.next;
        pre.next = newNode;

        size++;

    }

    public void deleteAtIndex(int index) {

        if (index < 0 || index >= size) {
            return;
        }
        ListNode pre = dummyHead;
        for (int i = 0; i < index ; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        size--;
    }


    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        // 测试头插
        list.addAtHead(1);  // [1]
        list.addAtHead(2);  // [2, 1]

        // 测试尾插
        list.addAtTail(3);  // [2, 1, 3]

        // 测试中间插入
        list.addAtIndex(1, 4);  // [2, 4, 1, 3]

        // 测试获取
        System.out.println(list.get(0));  // 应该输出 2
        System.out.println(list.get(1));  // 应该输出 4
        System.out.println(list.get(2));  // 应该输出 1
        System.out.println(list.get(3));  // 应该输出 3

        // 测试边界：在末尾插入（index = size）
        list.addAtIndex(4, 5);  // [2, 4, 1, 3, 5]
        System.out.println(list.get(4));  // 应该输出 5

        // 测试删除
        list.deleteAtIndex(1);  // [2, 1, 3, 5]
        System.out.println(list.get(1));  // 应该输出 1

        // 测试删除头节点
        list.deleteAtIndex(0);  // [1, 3, 5]
        System.out.println(list.get(0));  // 应该输出 1

        // 打印最终 size
        System.out.println("size: " + list.size);  // 应该输出 3
    }


}
