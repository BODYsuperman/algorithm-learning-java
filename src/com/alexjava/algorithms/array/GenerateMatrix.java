package com.alexjava.algorithms.array;

import java.util.Arrays;

public class GenerateMatrix {

    public static void main(String[] args) {

        test(1);
        test(3);
        test(4);
        test(5);
    }

    public  static  int[][] generateMatrix(int n){
        int[][] nums = new int[n][n];
        int startX = 0, startY = 0;
        int offSet = 1;
        int count = 1;
        int loop = 1;
        int i, j;
        
        while (loop<=n/2){
            //top j
            for (j = startY; j < n - offSet ; j++) {
                nums[startX][j] = count++;
            }
            //right i
            for (i = startX; i < n-offSet  ; i++) {
                nums[i][j] = count++;
            }
            //bottom j
            for (; j > startX ; j--) {
                nums[i][j] = count++;
            }
            //left i
            for (;  i > startY ; i--) {
                nums[i][j] = count++;
            }

            startX++;
            startY++;
            offSet++;
            loop++;


        }

        if(n%2 == 1){
            nums[startX][startY] = count;
        }
        return nums;
    }

    private static void test(int n) {
        System.out.println("n = " + n);
        int[][] result = generateMatrix(n);
        printMatrix(result);
        System.out.println();
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
    
}
