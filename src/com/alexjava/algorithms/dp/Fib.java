package com.alexjava.algorithms.dp;

public class Fib {

    public int fib(int n) {
        if (n < 2) return n;
        int a = 0, b = 1;


        for (int i = 2; i < n ; i++) {

            int sum = a+b;
            a = b;
            b = sum;

        }
        return b;
    }

    public int fib2(int n) {
        if (n <= 1) return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
