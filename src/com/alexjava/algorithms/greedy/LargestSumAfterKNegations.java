package com.alexjava.algorithms.greedy;

import java.util.Arrays;

public class LargestSumAfterKNegations {

    public int largestSumAfterKNegations(int[] nums, int k) {


        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(arr, (a, b) -> Math.abs(b) - Math.abs(a));

        for (int i = 0; i < arr.length && k > 0 ; i++) {

            if(arr[i] < 0){
                arr[i] = -arr[i];
                k--;
            }
        }
        if(k % 2 == 1){
            arr[arr.length - 1] = - arr[arr.length -1];
        }

        int sum = 0;
        for(int s : arr){
            sum += s;
        }

        return sum;

    }
}
