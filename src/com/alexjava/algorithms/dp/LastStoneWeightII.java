package com.alexjava.algorithms.dp;

public class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {

        int sum = 0;

        for (int stone: stones) sum+= stone;

        int target = sum>>1;
        int[] dp = new int[target +1];

        for (int i = 0; i < stones.length; i++) {

            for (int j = target; j >= stones[i]; j++) {

                dp[j] = Math.max(dp[j], dp[j- stones[i]] + stones[i]);
            }
        }

        return sum - 2 * dp[target];
    }
}
