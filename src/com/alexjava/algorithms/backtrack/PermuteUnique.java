package com.alexjava.algorithms.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {



    List<Integer> path = new ArrayList<>();

    List<List<Integer>>  res = new ArrayList<>();

    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {

        used = new boolean[nums.length];

        Arrays.sort(nums);

        dfs(nums);

        return res;

    }

    private void dfs(int[] nums) {

        if(path.size() == nums.length ){
            res.add(new ArrayList<>());
            return;
        }

        for (int i = 0; i < nums.length ; i++) {

            if(used[i]) continue;
            if(i > 0 && nums[i] == nums[i-1]&& !used[i-1]) continue;


            used[i] = true;

            path.add(nums[i]);

            dfs(nums);

            path.remove(path.size()-1);
            used[i] = false;

        }


    }
}
