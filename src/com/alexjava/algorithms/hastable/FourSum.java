package com.alexjava.algorithms.hastable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {


        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;
        for (int k = 0; k < n - 3; k++) {
            // 通用剪枝
            if ((long) nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3] > target) break;
            if ((long) nums[k] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) continue;

            if (k > 0 && nums[k] == nums[k - 1]) continue;

            for (int i = k + 1; i < n - 2; i++) {
                // 内层通用剪枝
                if ((long) nums[k] + nums[i] + nums[i + 1] + nums[i + 2] > target) break;
                if ((long) nums[k] + nums[i] + nums[n - 1] + nums[n - 2] < target) continue;

                if (i > k + 1 && nums[i] == nums[i - 1]) continue;

                int left = i + 1, right = n - 1;
                while (left < right) {
                    long sum = (long) nums[k] + nums[i] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        res.add(Arrays.asList(nums[k], nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
