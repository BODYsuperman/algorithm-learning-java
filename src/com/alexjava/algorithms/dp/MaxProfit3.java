package com.alexjava.algorithms.dp;

public class MaxProfit3 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        // 第一次交易的状态
        int hold1 = -prices[0];   // 第一次买入后持有
        int notHold1 = 0;         // 第一次卖出后不持有

        // 第二次交易的状态
        int hold2 = -prices[0];   // 第二次买入后持有
        int notHold2 = 0;         // 第二次卖出后不持有

        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];

            // 第一次交易
            notHold1 = Math.max(notHold1, hold1 + price);
            hold1 = Math.max(hold1, -price);

            // 第二次交易（基于第一次的利润）
            notHold2 = Math.max(notHold2, hold2 + price);
            hold2 = Math.max(hold2, notHold1 - price);
        }

        return notHold2;
    }
}
