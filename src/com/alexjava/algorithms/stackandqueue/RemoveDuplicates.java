package com.alexjava.algorithms.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveDuplicates {
    public String removeDuplicates(String S) {

        Deque<Character> deque = new ArrayDeque<>();


        for (char ch: S.toCharArray()){
            if(deque.isEmpty() || ch != deque.peek()){
                deque.push(ch);
            }
            else{
                deque.pop();
            }
        }


        String str= "";
        while (!deque.isEmpty()){
            str = deque.pop() + str;
        }
        return str;
    }
}
