package com.alexjava.algorithms.strings;

public class KmpAlogrithmn {

    public static int kmpSearch(String s, String p) {



        int n = s.length();
        int m = p.length();

        int[] next = computeNext(p);

        int i = 0;
        int j = 0;
        while (i < n){
            if(s.charAt(i) == p.charAt(j)){
                i++;
                j++;
                if(j == m){
                    return i - m;
                }
            }
            else{
                if(j> 0){
                    j = next[j-1];
                }
                else{
                    i++;
                }
            }
        }
        return -1;
    }

    public  static  int[] computeNext(String p){
        // j pre i post

        int m = p.length();
        int j = 0;

        int[] next = new int[m];

        for (int i = 1; i < m ; i++) {

            while (j > 0 && p.charAt(i) != p.charAt(j)){
                j = next[j-1];
            }
            if(p.charAt(i) == p.charAt(j)){
                j++;
            }

            next[i] = j;
        }

        return next;

    }
}
