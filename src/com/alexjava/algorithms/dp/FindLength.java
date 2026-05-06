package com.alexjava.algorithms.dp;

public class FindLength {

    public int findLength(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m  = nums2.length;

        int[][] dp = new int[n+1][m+1];

        int res = 0;
        for (int i = 1; i <= n ; i++) {

            for (int j = 1; j <= m ; j++) {

                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }

        return res;
    }
}
