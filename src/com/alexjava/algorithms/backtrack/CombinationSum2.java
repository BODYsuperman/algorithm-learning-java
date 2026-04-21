package com.alexjava.algorithms.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {


    List<List<Integer>> res  =  new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {


        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return res;
    }

    private  void dfs(int[] candidates, int target, int startIndex){

        if(target < 0) return;
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {

            if (candidates[i] > target) break;

            if(i > startIndex && candidates[i] == candidates[i-1]) continue;


            path.add(candidates[i]);
            //can't be duplicated
            dfs(candidates, target - candidates[i], i + 1);
            path.remove(path.size() -1);
        }

    }


}
