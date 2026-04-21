package com.alexjava.algorithms.backtrack;

import java.util.ArrayList;
import java.util.List;

public class SubSets {


    List<Integer> path =  new ArrayList<>();
    List<List<Integer>> res =  new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {


        dfs(nums, 0);

        return res;

    }

    private void dfs(int[] nums, int startIndex) {

        res.add(new ArrayList<>(path));

        for (int i = startIndex; i < nums.length; i++) {


            path.add(nums[i]);
            dfs(nums, i+1);
            path.remove(path.size()-1);
        }
    }


}
