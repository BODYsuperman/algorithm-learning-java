package com.alexjava.algorithms.dp;

public class CountSubstrings {

    public int countSubstrings(String s) {

        int n = s.length();
        boolean [][] dp = new boolean[n][n];

        int res = 0;

        for (int i = n-1; i >= 0 ; i--) {

            for (int j = i; j < n ; j++) {

                if(s.charAt(i) == s.charAt(j)){
                    if(j - i <= 1){
                        dp[i][j] = true;
                    }
                    else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j]) res++;
            }

        }


        return res;
    }

    public int countSubstrings1(String s) {
        int n = s.length();
        int res = 0;

        for (int i = 0; i < n; i++) {
            // 奇数
            res += expand(s, i, i);
            // 偶数
            res += expand(s, i, i + 1);
        }

        return res;
    }

    private int expand(String s, int left, int right) {
        int count = 0;

        while (left >= 0 && right < s.length() &&
                s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }

        return count;
    }
}
