package com.alexjava.algorithms.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Permute {



    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {

        used = new boolean[nums.length];
        dfs(nums);
        return res;
    }

    private void dfs(int[] nums) {

        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length ; i++) {


            if(used[i]) continue;

            used[i] = true;

            path.add(nums[i]);
            dfs(nums);

            path.remove(path.size() -1);
            used[i] = false;


        }

    }
}
