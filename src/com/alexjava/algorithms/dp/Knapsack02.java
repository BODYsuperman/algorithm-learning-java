package com.alexjava.algorithms.dp;

import java.util.Scanner;

public class Knapsack02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取 M 和 N
        int M = scanner.nextInt();  // 研究材料的数量
        int N = scanner.nextInt();  // 行李空间的大小

        int[] costs = new int[M];   // 每种材料的空间占用
        int[] values = new int[M];  // 每种材料的价值

        // 输入每种材料的空间占用
        for (int i = 0; i < M; i++) {
            costs[i] = scanner.nextInt();
        }

        // 输入每种材料的价值
        for (int j = 0; j < M; j++) {
            values[j] = scanner.nextInt();
        }

        // 创建一个动态规划数组 dp，初始值为 0
        int[] dp = new int[N + 1];


        for (int i = 0; i < M; i++) {

            for (int j = N; j >= costs[i] ; j--) {

                dp[j] = Math.max(dp[j], dp[j-costs[i]] + values[i]);
            }
        }
        // 输出 dp[N]，即在给定 N 行李空间可以携带的研究材料的最大价值
        System.out.println(dp[N]);

        scanner.close();
        

    }
}
