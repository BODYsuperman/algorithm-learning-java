package com.alexjava.algorithms.stackandqueue;

import java.util.Stack;

public class IsValid {
    public  boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()) {

            if(c == ')' && !stack.isEmpty() && stack.peek()== '('){
                stack.pop();
            }
            else if(c == ']' && !stack.isEmpty() && stack.peek()== '['){
                stack.pop();
            }
            else if(c == '}' && !stack.isEmpty() && stack.peek()== '{'){
                stack.pop();
            }
            else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
