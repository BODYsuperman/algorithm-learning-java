package com.alexjava.algorithms.greedy;

public class CanCompleteCircuit {

    public int canCompleteCircuit(int[] gas, int[] cost) {


        int curSum = 0;
        int totalSum = 0;

        int start = 0;

        for (int i = 0; i < gas.length; i++) {

            int diff = gas[i] - cost[i];

            curSum += diff;
            totalSum += diff;


            if (curSum < 0) {

                start = i + 1;
                curSum = 0;
            }

        }

        return totalSum >=0? start : -1;


    }


}
