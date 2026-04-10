package com.alexjava.algorithms.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    Queue<Integer> queue;
    public MyStack(){
        queue = new LinkedList<>();
    }


    public void push(int x){
        queue.offer(x);
        int size = queue.size();
        for (int i = 0; i < size-1 ; i++) {
            queue.offer(queue.poll());
        }
    }

    public int top(){
        return queue.peek();
    }

    public  int pop(){
        return queue.poll();
    }

    public  boolean isEmpty(){
        return queue.isEmpty();
    }



}
