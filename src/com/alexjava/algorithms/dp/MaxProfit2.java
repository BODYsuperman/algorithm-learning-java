package com.alexjava.algorithms.dp;

public class MaxProfit2 {

    public int maxProfit(int[] prices) {

        int res = 0;

        for (int i = 1; i < prices.length ; i++) {

            if(prices[i] > prices[i-1]){
                res+= prices[i] -prices[i-1];
            }
        }

        return  res;
    }

    public int maxProfit1(int[] prices) {

        // 0 not hold
        // 1 hold
        int n = prices.length;

        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n ; i++) {

            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);

            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[n-1][0];

    }
}
