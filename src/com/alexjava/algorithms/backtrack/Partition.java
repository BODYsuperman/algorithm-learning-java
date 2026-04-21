package com.alexjava.algorithms.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Partition {


    List<String> path = new ArrayList<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        
        dfs(s, 0);
        return res;

    }

    private void dfs(String s, int startIndex) {

        //to the end
        if(startIndex == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length() ; i++) {

            if(!isPalindrome(s, startIndex, i)) continue;

            path.add(s.substring(startIndex, i+1));

            dfs(s, i+1);

            path.remove(path.size()-1);

        }
    }

    private boolean isPalindrome(String s, int left, int right) {

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
