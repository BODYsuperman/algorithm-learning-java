package com.alexjava.algorithms.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Combine {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1);
        return res;
    }

    private void dfs(int n, int k, int start) {


        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }


        //n - i + 1 >= k-path.size()
        for (int i = start; i <= n - (k- path.size()) + 1 ; i++) {

            path.add(i);

            dfs(n , k, i+1);

            path.remove(path.size() -1);
        }
    }


}
