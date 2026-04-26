package com.alexjava.algorithms.greedy;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {


        int[] last = new int[26];

        int start = 0;
        int end = 0;

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length() ; i++) {

           last[s.charAt(i)-'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {

            end = Math.max(end, last[s.charAt(i)-'a']);

            if(i == end){
                res.add(end - start +1  );
                start = i+1;
            }


        }

        return res;

    }

}