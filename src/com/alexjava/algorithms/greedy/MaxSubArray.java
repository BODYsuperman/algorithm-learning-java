package com.alexjava.algorithms.greedy;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int curSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            curSum = Math.max(nums[i], nums[i] + curSum);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;

    }
}
