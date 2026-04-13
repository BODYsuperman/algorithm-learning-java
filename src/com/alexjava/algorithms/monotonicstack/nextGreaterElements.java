package com.alexjava.algorithms.monotonicstack;

import java.util.Arrays;
import java.util.Stack;

public class nextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {


        if(nums == null || nums.length <= 1){
            return new int[]{-1};
        }

        int size = nums.length;
        int[] res = new int[size];
        Arrays.fill(res, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < size*2; i++) {

            while (!stack.isEmpty() && nums[i%size] > nums[stack.peek()]){
                res[stack.peek()] = nums[i% size];
                stack.pop();
            }
            stack.push(i%size);
        }

        return res;

    }
}
