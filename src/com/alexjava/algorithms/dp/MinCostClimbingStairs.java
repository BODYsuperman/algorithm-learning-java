package com.alexjava.algorithms.dp;

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int a = 0, b = 0, cur = 0;

        for (int i = 2; i < cost.length; i++) {

            cur = Math.min(a + cost[i-2], b + cost[i-1]);

            a = b;
            b = cur;
        }
        return b;

    }
    public int minCostClimbingStairs1(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(
                    dp[i - 1] + cost[i - 1],
                    dp[i - 2] + cost[i - 2]
            );
        }

        return dp[n];
    }
}
