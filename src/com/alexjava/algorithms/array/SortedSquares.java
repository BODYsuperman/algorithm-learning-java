package com.alexjava.algorithms.array;

public class SortedSquares {
    public static void main(String[] args) {

        int[] test1 = {-4, -1, 0, 3, 10};
        System.out.print("测试用例1（混合）结果：");
        printArray(sortedSquares(test1));

        // 测试用例2：全负数
        int[] test2 = {-7, -3, -2, -1};
        System.out.print("测试用例2（全负）结果：");
        printArray(sortedSquares(test2));

        // 测试用例3：全正数
        int[] test3 = {1, 2, 4, 7, 9};
        System.out.print("测试用例3（全正）结果：");
        printArray(sortedSquares(test3));

        // 测试用例4：单元素（负/0/正各一个）
        int[] test4_1 = {-5};
        int[] test4_2 = {0};
        int[] test4_3 = {8};
        System.out.print("测试用例4-1（单负）结果：");
        printArray(sortedSquares(test4_1));
        System.out.print("测试用例4-2（单0）结果：");
        printArray(sortedSquares(test4_2));
        System.out.print("测试用例4-3（单正）结果：");
        printArray(sortedSquares(test4_3));

        // 测试用例5：空数组
        int[] test5 = {};
        System.out.print("测试用例5（空数组）结果：");
        printArray(sortedSquares(test5));

        // 测试用例6：null
        int[] test6 = null;
        System.out.print("测试用例6（null）结果：");
        printArray(sortedSquares(test6));

        // 测试用例7：有重复值
        int[] test7 = {-5, -5, 2, 2, 3};
        System.out.print("测试用例7（重复值）结果：");
        printArray(sortedSquares(test7));



    }

    /*
    input：nums = [-4,-1,0,3,10]
    output：[0,1,9,16,100]
    解释：平方后，数组变为 [16,1,0,9,100]，排序后，数组变为 [0,1,9,16,100]
 */
    public  static  int[] sortedSquares(int[] nums){

        if(nums==null|| nums.length == 0) return  new int[]{};

        int n = nums.length;

        int left = 0;
        int right = n -1;
        int index = n - 1;

        int[] res = new int[n];

        while (left <= right){
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if(leftSquare > rightSquare){
                res[index--] = leftSquare;
                ++left;
            }
            else{
                res[index--] = rightSquare;
                --right;
            }
        }
        return res;
    }

    private static void printArray(int[] arr) {
        if (arr == null) {
            System.out.println("null");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
