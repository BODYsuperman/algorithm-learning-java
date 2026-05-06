package com.alexjava.algorithms.dp;

public class FindLengthOfLCIS {

    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0) return 0;

        int res = 1;
        int dp = 1;
        for (int i = 1; i < nums.length ; i++) {

            if(nums[i]> nums[i-1]){
                dp = dp +1;
            }
            else {
                dp = 1;
            }

            res = Math.max(res, dp);
        }

        return res;

    }
}
