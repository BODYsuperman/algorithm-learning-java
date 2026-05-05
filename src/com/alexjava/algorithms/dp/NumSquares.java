package com.alexjava.algorithms.dp;

import java.util.Arrays;

public class NumSquares {
    public int numSquares(int n) {

        int[] dp = new int[n+1];

        Arrays.fill(dp, n+1);

        dp[0] = 0;

        for (int i = 0; i <=n ; i++) {

            int square = i*i;

            for (int j = square; j <= n ; j++) {

                dp[j] = Math.min(dp[j], dp[j - square] + 1);
            }
        }

        return dp[n];
    }
}
