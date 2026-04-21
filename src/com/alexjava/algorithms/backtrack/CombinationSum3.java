package com.alexjava.algorithms.backtrack;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {


    List<List<Integer>> res =  new ArrayList<>();

    List<Integer> path =  new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {

        dfs(k, n , 1, 0);


        return res;

    }

    //k means sum  of k  numbers is n
    private void dfs(int k, int n, int start, int sum) {
        if(sum > n) return;

        if(path.size() == k){
            if( sum == n){
                res.add(new ArrayList<>(path));
            }
            return;
        }


        for (int i = start; i <= 9 -(k - path.size()) + 1; i++) {
            path.add(i);

            ///sum+=i;
            dfs(k , n , i+ 1, sum + i);

            path.remove(path.size() - 1);
            //sum-=i;
        }

    }
}
