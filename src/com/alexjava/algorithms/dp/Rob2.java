package com.alexjava.algorithms.dp;

public class Rob2 {

    public int rob(int[] nums) {


        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        if(n == 1) return nums[0];





        return Math.max(

                robRange(nums, 0, n-2),
                robRange(nums, 1, n-1)
        );


    }

    private int robRange(int[] nums, int start, int end) {

        int len = end -start +1;
        int[] dp = new int[len];

        dp[0] = nums[start];
        if(len == 1) return dp[0];

        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < len ; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[start + i]);
        }



        return dp[len - 1];
    }
}
