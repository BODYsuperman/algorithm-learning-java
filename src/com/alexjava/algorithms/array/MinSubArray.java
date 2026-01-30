package com.alexjava.algorithms.array;

public class MinSubArray {
    public static void main(String[] args) {

        testCase(7, new int[]{2, 3, 1, 2, 4, 3}, 1);
        // 测试用例2：单元素刚好等于target（最小长度1）
        testCase(4, new int[]{4}, 2);
        // 测试用例3：单元素小于target（无解，返回0）
        testCase(5, new int[]{4}, 3);
        // 测试用例4：所有元素和刚好等于target（最小长度=数组长度）
        testCase(15, new int[]{1, 2, 3, 4, 5}, 4);
        // 测试用例5：多个连续子数组达标，取最短（如[5,1]和[6]，取1）
        testCase(6, new int[]{2, 5, 1, 6, 3}, 5);
        // 测试用例6：无解（所有元素和<target）
        testCase(20, new int[]{1, 2, 3, 4, 5}, 6);
        // 测试用例7：空数组（直接返回0）
        testCase(5, new int[]{}, 7);
        // 测试用例8：数组有连续大值（最小窗口为单个大值）
        testCase(10, new int[]{1, 1, 1, 10, 2, 3}, 8);

    }

    //Given an array of positive integers nums and a positive integer target,
    // return the minimal length of a subarray whose sum is greater than or equal to target.
    public  static int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int res = Integer.MAX_VALUE;
        int sum = 0;

        for (int right = 0; right < nums.length; right++) {

            sum+=nums[right];
            while (sum >= target){
                res = Math.min(res, right-left+1);
                sum-=nums[left++];
            }
        }

        return  res==Integer.MAX_VALUE?0:res;

    }



    private static void testCase(int target, int[] nums, int caseNum) {
        int result = minSubArrayLen(target, nums);
        System.out.printf("测试用例%d | target=%d | 数组=%s | 最小子数组长度=%d%n",
                caseNum,
                target,
                arrayToString(nums),
                result);
    }

    private static String arrayToString(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
            if (i < nums.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
