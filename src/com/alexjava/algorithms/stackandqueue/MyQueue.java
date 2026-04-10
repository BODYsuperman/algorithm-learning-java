package com.alexjava.algorithms.stackandqueue;

import java.util.Stack;

public class MyQueue {

    Stack<Integer> stackIn;

    Stack<Integer> stackOut;

    public MyQueue(){
        //responsible  for stack in
        stackIn = new Stack<>();
        //responsible for stack out
        stackOut = new Stack<>();
    }

    public  void push(int x){
        stackIn.push(x);
    }

    public  int pop(){
        dumpstackIn();
        return stackOut.pop();
    }

    public  int peek(){
        dumpstackIn();
        return stackOut.peek();
    }

    public boolean isEmpty(){
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    public  void dumpstackIn(){
        if(!stackOut.isEmpty()) return;
        while (!stackIn.isEmpty()){
            stackOut.push(stackIn.pop());
        }
    }
}
