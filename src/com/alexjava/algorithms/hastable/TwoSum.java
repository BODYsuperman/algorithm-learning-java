package com.alexjava.algorithms.hastable;

import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int balance = target - nums[i];
            if(indexMap.containsKey(balance)){
                return  new int[]{i, indexMap.get(balance)};
            }
            else {
                indexMap.put(nums[i], i);
            }
        }

        return null;

    }
}
