package com.alexjava.algorithms.greedy;

import java.util.Arrays;

public class FindContentChildren {

    public  int findContentChildren(int[] g, int[] s) {


        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;//child
        int j = 0;//biscuit

        while (i < g.length && j < s.length){

            if(s[j] >= g[i]){
                i++;
            }
            j++;
        }
        return i;


    }
}
