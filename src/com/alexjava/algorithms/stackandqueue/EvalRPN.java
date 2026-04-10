package com.alexjava.algorithms.stackandqueue;

import java.util.ArrayDeque;

public class EvalRPN {

    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(String s: tokens){
            if("+".equals(s)){
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(s)) {
                int b = stack.pop();
                int a = stack.peek();
                stack.push(a - b);
            } else if ("*".equals(s)) {
                stack.push(stack.pop()*stack.pop());
            } else if ("/".equals(s)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(b/a);
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }
}
