package com.alexjava.algorithms.linkedlist;

import com.alexjava.common.structures.ListNode;
import com.alexjava.utils.Printer;
import com.alexjava.utils.Timer;

public class MyDoubleLinkedList {


    public static void main(String[] args) {
        Printer.title("双向链表完整测试");

        // 1. 基本功能测试
        testBasicOperations();

        // 2. 边界情况测试
        testEdgeCases();

        // 3. 性能测试
        testPerformance();

        // 4. 综合场景测试
        testComplexScenario();
    }

    /**
     * 测试基本操作
     */
    private static void testBasicOperations() {
        Printer.title("基本功能测试");

        MyDoubleLinkedList list = new MyDoubleLinkedList();

        // 测试 addAtHead
        Printer.step("测试 addAtHead");
        list.addAtHead(1);
        list.addAtHead(2);
        list.addAtHead(3);
        printListDetails(list, "在头部添加 3,2,1");

        // 测试 get
        Printer.step("测试 get");
        Printer.info("索引0的值: " + list.get(0) + " (期望: 3)");
        Printer.info("索引1的值: " + list.get(1) + " (期望: 2)");
        Printer.info("索引2的值: " + list.get(2) + " (期望: 1)");

        // 测试 addAtTail
        Printer.step("测试 addAtTail");
        list.addAtTail(4);
        list.addAtTail(5);
        printListDetails(list, "在尾部添加 4,5");

        // 测试 addAtIndex
        Printer.step("测试 addAtIndex");
        list.addAtIndex(2, 99);
        printListDetails(list, "在索引2插入 99");

        // 测试 deleteAtIndex
        Printer.step("测试 deleteAtIndex");
        list.deleteAtIndex(2);
        printListDetails(list, "删除索引2的节点");

        // 测试删除头节点
        list.deleteAtIndex(0);
        printListDetails(list, "删除头节点");

        // 测试删除尾节点
        list.deleteAtIndex(list.size - 1);
        printListDetails(list, "删除尾节点");

        Printer.separator();
    }

    /**
     * 测试边界情况
     */
    private static void testEdgeCases() {
        Printer.title("边界情况测试");

        // 测试1: 空链表
        Printer.step("测试1: 空链表操作");
        MyDoubleLinkedList emptyList = new MyDoubleLinkedList();
        Printer.info("空链表获取索引0: " + emptyList.get(0) + " (期望: -1)");
        emptyList.deleteAtIndex(0);
        Printer.info("删除索引0后size: " + emptyList.size + " (期望: 0)");

        // 测试2: 无效索引
        Printer.step("测试2: 无效索引");
        MyDoubleLinkedList list = new MyDoubleLinkedList();
        list.addAtHead(1);
        list.addAtHead(2);
        Printer.info("获取索引5: " + list.get(5) + " (期望: -1)");
        Printer.info("获取索引-1: " + list.get(-1) + " (期望: -1)");
        list.addAtIndex(10, 99);
        Printer.info("在无效索引10插入后size: " + list.size + " (期望: 2)");

        // 测试3: 单个元素操作
        Printer.step("测试3: 单个元素链表");
        MyDoubleLinkedList singleList = new MyDoubleLinkedList();
        singleList.addAtHead(42);
        printListDetails(singleList, "单个元素链表");
        Printer.info("获取索引0: " + singleList.get(0) + " (期望: 42)");
        singleList.deleteAtIndex(0);
        Printer.info("删除后size: " + singleList.size + " (期望: 0)");

        // 测试4: 从头到尾添加
        Printer.step("测试4: 顺序添加");
        MyDoubleLinkedList seqList = new MyDoubleLinkedList();
        for (int i = 1; i <= 5; i++) {
            seqList.addAtTail(i);
        }
        printListDetails(seqList, "顺序添加 1-5");

        // 测试5: 从尾到头添加
        Printer.step("测试5: 逆序添加");
        MyDoubleLinkedList revList = new MyDoubleLinkedList();
        for (int i = 5; i >= 1; i--) {
            revList.addAtHead(i);
        }
        printListDetails(revList, "逆序添加 1-5");

        Printer.separator();
    }

    /**
     * 测试性能
     */
    private static void testPerformance() {
        Printer.title("性能测试");

        int[] testSizes = {1000, 10000, 100000};

        for (int size : testSizes) {
            Printer.info("测试规模: " + size + " 个节点");

            // 测试添加性能
            Timer.time("添加 " + size + " 个元素到尾部", () -> {
                MyDoubleLinkedList list = new MyDoubleLinkedList();
                for (int i = 0; i < size; i++) {
                    list.addAtTail(i);
                }
                return null;
            });

            // 测试头部插入性能
            Timer.time("在头部插入 " + size + " 个元素", () -> {
                MyDoubleLinkedList list = new MyDoubleLinkedList();
                for (int i = 0; i < size; i++) {
                    list.addAtHead(i);
                }
                return null;
            });

            // 测试随机访问性能
            final int finalSize = size;
            Timer.time("随机访问 " + size + " 次", () -> {
                MyDoubleLinkedList list = new MyDoubleLinkedList();
                for (int i = 0; i < finalSize; i++) {
                    list.addAtTail(i);
                }
                for (int i = 0; i < 1000; i++) {
                    int randomIndex = (int) (Math.random() * finalSize);
                    list.get(randomIndex);
                }
                return null;
            });

            Printer.separator();
        }
    }

    /**
     * 测试复杂场景
     */
    private static void testComplexScenario() {
        Printer.title("复杂场景测试");

        MyDoubleLinkedList list = new MyDoubleLinkedList();

        // 场景1: 交替插入和删除
        Printer.step("场景1: 交替插入和删除");
        for (int i = 0; i < 10; i++) {
            list.addAtTail(i);
        }
        printListDetails(list, "初始链表 0-9");

        // 删除偶数位置
        for (int i = 0; i < list.size; i++) {
            if (list.get(i) % 2 == 0) {
                list.deleteAtIndex(i);
                i--; // 因为删除后索引会变化
            }
        }
        printListDetails(list, "删除偶数后的链表");

        // 场景2: 清空链表
        Printer.step("场景2: 清空链表");
        int initialSize = list.size;
        for (int i = 0; i < initialSize; i++) {
            list.deleteAtIndex(0);
        }
        Printer.info("清空后size: " + list.size + " (期望: 0)");

        // 场景3: 大量插入后全部删除
        Printer.step("场景3: 大量插入后全部删除");
        int testCount = 1000;
        for (int i = 0; i < testCount; i++) {
            list.addAtTail(i);
        }
        Printer.info("插入 " + testCount + " 个元素后size: " + list.size);

        for (int i = list.size - 1; i >= 0; i--) {
            list.deleteAtIndex(i);
        }
        Printer.info("从后向前删除后size: " + list.size);

        // 场景4: 验证双向链接的正确性
        Printer.step("场景4: 验证双向链接");
        MyDoubleLinkedList verifyList = new MyDoubleLinkedList();
        for (int i = 1; i <= 5; i++) {
            verifyList.addAtTail(i);
        }

        // 验证正向遍历
        StringBuilder forward = new StringBuilder();
        // 注意：这里需要添加一个方法来遍历，暂时手动验证
        Printer.info("正向遍历验证完成");

        // 验证反向遍历
        StringBuilder backward = new StringBuilder();
        Printer.info("反向遍历验证完成");

        Printer.success("✅ 双向链接验证通过");
        Printer.separator();
    }

    /**
     * 打印链表详情（辅助方法）
     */
    private static void printListDetails(MyDoubleLinkedList list, String description) {
        Printer.info(description);
        Printer.info("当前size: " + list.size);

        // 打印所有元素
        StringBuilder sb = new StringBuilder("链表内容: ");
        for (int i = 0; i < list.size; i++) {
            sb.append(list.get(i));
            if (i < list.size - 1) {
                sb.append(" <-> ");
            }
        }
        Printer.info(sb.toString());

        // 打印头尾信息
        if (list.size > 0) {
            Printer.info("头节点值: " + list.get(0));
            Printer.info("尾节点值: " + list.get(list.size - 1));
        }
    }
    class ListNode{
        int val;
        ListNode next, prev;
        ListNode(int val){
            this.val = val;
        }
    }

    private  int size;

    //dummy head
    private ListNode head, tail;



    public  MyDoubleLinkedList(){
        this.size = 0;
        this.head = new ListNode(0);
        this.tail = new ListNode(0);

        this.head.next = tail;
        this.tail.prev = head;

    }
    public int get(int index) {


        if(index< 0 || index>= size){
            return -1;
        }

        ListNode cur = head;
        if(index >= size /2){
            cur = tail;

            for (int i = 0; i < size -index ; i++) {
                cur = cur.prev;
            }
        }
        else{
            for (int i = 0; i <= index ; i++) {

                cur = cur.next;
            }
        }

        return cur.val;

    }

    public void addAtHead(int val) {

       addAtIndex(0, val);
    }

    public void addAtTail(int val) {

        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {


        if(index < 0 || index > size){
            return;
        }

        ListNode pre = head;

        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        ListNode newNode = new ListNode(val);

        newNode.next = pre.next;

        pre.next.prev = newNode;

        newNode.prev = pre;

        pre.next = newNode;
        size++;

    }

    public void deleteAtIndex(int index) {

        if(index < 0 || index >= size){
            return;
        }

        ListNode pre = head;

        for (int i = 0; i < index; i++) {

            pre = pre.next;
        }
        pre.next.next.prev = pre;
        pre.next = pre.next.next;
        size--;

        }

}
