package com.alexjava.algorithms.dp;

public class IntegerBreak {

    public int integerBreak(int n) {

        int[] dp = new int[n+1];

        dp[2] = 1;

        for (int i = 3; i <= n ; i++) {

            for (int j = 1; j <= i/2 ; j++) {

                dp[i] = Math.max(Math.max(j*(i-j), j*dp[i-j]), dp[i]);
            }
        }
        return dp[n];
    }

}
