package com.alexjava.algorithms.dp;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {

        int res = nums[0];
        int cur = nums[0];

        for (int i = 1; i < nums.length; i++) {

            cur = Math.max(nums[i], cur + nums[i]);
            res = Math.max(cur,res);
        }
        return res;
    }

    public int maxSubArray1(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];
        int res = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
