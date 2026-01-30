package com.alexjava.algorithms.array;

import java.util.Scanner;

public class PreFix {

    public static void main(String[] args) {


        //prefix[b] = 0 ... a-1 | a ... b
        //               ↑
        //           must subtract
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] prefix = new int[n];

        prefix[0] = arr[0] = sc.nextInt();
        for (int i = 1; i < n ; i++) {
            arr[i] = sc.nextInt();
            prefix[i] = arr[i]+ prefix[i-1];
        }


        while (sc.hasNextInt()){
            int a = sc.nextInt();
            int b = sc.nextInt();

            int res = (a==0) ?prefix[b]: prefix[b] - prefix[a-1];
            System.out.println(res);
        }
        sc.close();
    }
}
