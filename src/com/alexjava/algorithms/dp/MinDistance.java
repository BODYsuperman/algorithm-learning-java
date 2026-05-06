package com.alexjava.algorithms.dp;

public class MinDistance {


    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int lsc = longestCommonSubsequence(word1, word2);



        return n+m - 2*lsc;
    }

    public int longestCommonSubsequence(String text1, String text2){

        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n ; i++) {

            for (int j = 1; j <= m ; j++) {

                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public int minDistance2(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i <= n; i++) dp[i][0] = i;
        for (int j = 0; j <= m; j++) dp[0][j] = j;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(
                            dp[i-1][j] + 1,
                            dp[i][j-1] + 1
                    );
                }

            }
        }

        return dp[n][m];
    }
}
