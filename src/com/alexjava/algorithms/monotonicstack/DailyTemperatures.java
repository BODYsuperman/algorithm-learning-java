package com.alexjava.algorithms.monotonicstack;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures){
        
        int n = temperatures.length;
        
        int[] res = new int[n];

        Deque<Integer> stack = new LinkedList<>();
        //t[i] > stack.peek
        for (int i = 0; i < temperatures.length; i++) {

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }

            stack.push(i);
        }
        return res;
    }
}
