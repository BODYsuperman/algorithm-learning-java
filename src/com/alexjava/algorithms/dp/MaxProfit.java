package com.alexjava.algorithms.dp;

public class MaxProfit {

    public int maxProfit(int[] prices) {

        int n = prices.length;
        //0 sold 1 hold
        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n ; i++) {

            dp[i][0] = Math.max(dp[i-1][1],
                    dp[i][1] + prices[i]);

            dp[i-1][1] = Math.max(dp[i-1][1], -prices[i]);
        }

        return dp[n-1][0];

    }

    public int maxProfit1(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {

            // 记录历史最低价
            minPrice = Math.min(minPrice, price);

            // 计算当前卖出的最大利润
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;

    }
}
