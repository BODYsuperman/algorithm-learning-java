package com.alexjava.algorithms.dp;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {

        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n ; i++) {

            for (int j = 1; j <= m ; j++) {

                if(s.charAt(i-1) == t.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[n][m] == n;
    }

    public boolean isSubsequence1(String s, String t) {

        int i = 0, j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }
}
