package com.alexjava.algorithms.greedy;

public class Jump {

    int steps = 0;
    int curEnd = 0;
    int nextEnd = 0;
    public int jump(int[] nums) {


        for (int i = 0; i < nums.length -1 ; i++) {

            nextEnd = Math.max(nextEnd, i + nums[i]);

            if(i == curEnd){
                steps++;
                curEnd = nextEnd;
            }
        }
        return steps;


    }
}
