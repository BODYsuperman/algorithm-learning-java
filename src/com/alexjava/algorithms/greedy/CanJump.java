package com.alexjava.algorithms.greedy;

public class CanJump {

    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int coverRange = 0;

        for (int i = 0; i <= coverRange && i < nums.length; i++) {

            coverRange = Math.max(coverRange, i+ nums[i]);

            if(coverRange >= nums.length -1){
                return true;
            }
        }
        return false;


    }
}
