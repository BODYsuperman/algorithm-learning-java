package com.alexjava.algorithms.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindSubsequences {



    List<Integer> path =  new ArrayList<>();
    List<List<Integer>> res =  new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int startIndex) {

        if(path.size() >= 2){
            res.add(new ArrayList<>(path));
        }

        //remove the duplicate num at different levels
        Set<Integer> used = new HashSet<>();

        for (int i = startIndex; i < nums.length; i++) {

            if(!path.isEmpty() && nums[i] < path.get(path.size() -1)) continue;

            if(used.contains(nums[i])) continue;
            used.add(nums[i]);

            path.add(nums[i]);
            dfs(nums, i+1);
            path.remove(path.size() -1);

        }


    }
}
