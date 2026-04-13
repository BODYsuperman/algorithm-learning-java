package com.alexjava.algorithms.monotonicstack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        //nums1 nums2

        if(nums1 == null || nums1.length <= 1) return new int[]{-1};

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length ; i++) {
            map.put(nums1[i], i);
        }

        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {

            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                int pre = nums2[stack.pop()];

                if(map.containsKey(pre)){
                    res[map.get(pre)] = nums2[i];
                }
            }
            stack.push(i);
        }

        return res;


    }
}
