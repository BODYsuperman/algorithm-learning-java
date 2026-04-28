package com.alexjava.algorithms.dp;

import java.util.Scanner;

public class Knapsack01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int bagweight = scanner.nextInt();
        int[] weight = new int[n];
        int[] value = new int[n];

        for (int i = 0; i < n; i++) {

            weight[i] = scanner.nextInt();
        }


        for (int j = 0; j < n; j++) {

            value[j] = scanner.nextInt();
        }

        int[][] dp = new int[n][bagweight + 1];

        for (int j = weight[0];j <= bagweight;j++){
            dp[0][j] = value[0];
        }

        for (int i = 1; i < n; i++){
            for (int j = 0; j <= bagweight ; j++) {

                //not choose the ithe goods
                dp[i][j] = dp[i-1][j];

                if(j >= weight[i]){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i-1]] + value[i-2]);
                }
            }
        }

        System.out.println(dp[n - 1][bagweight]);



    }
}
