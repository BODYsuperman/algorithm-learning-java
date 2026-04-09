package com.alexjava.algorithms.strings;

public class SubStringPattern {

    public boolean repeatedSubstringPattern(String s) {



        int n = s.length();
        int[] next = new int[n];

        int j = 0;
        next[0] = 0;

        for (int i = 1; i < n ; i++) {

            while (i> 0 && s.charAt(j) != s.charAt(i)){
                j = next[j-1];
            }
            if(s.charAt(i) == s.charAt(j)){
                j++;
            }

            next[i] = j;

        }

        if(next[n-1] > 0 && n % (n - next[n-1]) == 0){
            return true;
        }
        else {
            return false;
        }


    }
}
