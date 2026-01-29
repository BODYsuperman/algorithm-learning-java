package com.alexjava.algorithms.array;

public class BinarySearch {


    public static void main(String[] args) {

        System.out.println("Binary Search Simple Test\n");

        // Test 1: Basic array
        System.out.println("Test 1: Basic array [1, 3, 5, 7, 9]");
        int[] arr1 = {1, 3, 5, 7, 9};
        test(arr1, 1);   // Should return 0
        test(arr1, 5);   // Should return 2
        test(arr1, 9);   // Should return 4
        test(arr1, 4);   // Should return -1 (not found)
        test(arr1, 0);   // Should return -1
        test(arr1, 10);  // Should return -1

        // Test 2: Edge cases
        System.out.println("\nTest 2: Edge cases");
        int[] arr2 = {5};  // Single element
        test(arr2, 5);     // Should return 0
        test(arr2, 3);     // Should return -1

        int[] arr3 = {2, 5};  // Two elements
        test(arr3, 2);     // Should return 0
        test(arr3, 5);     // Should return 1
        test(arr3, 3);     // Should return -1

        // Test 3: Empty array
        System.out.println("\nTest 3: Empty array");
        int[] arr4 = {};
        test(arr4, 5);     // Should return -1

        // Test 4: Negative numbers
        System.out.println("\nTest 4: Negative array [-5, -3, 0, 2, 4]");
        int[] arr5 = {-5, -3, 0, 2, 4};
        test(arr5, -5);    // Should return 0
        test(arr5, -3);    // Should return 1
        test(arr5, 0);     // Should return 2
        test(arr5, 4);     // Should return 4
        test(arr5, -2);    // Should return -1

        // Test 5: Duplicate elements
        System.out.println("\nTest 5: Duplicate elements [1, 2, 2, 2, 3]");
        int[] arr6 = {1, 2, 2, 2, 3};
        test(arr6, 2);     // Binary search may return any index 1, 2, or 3

        // Test 6: All same elements
        System.out.println("\nTest 6: All same [7, 7, 7, 7]");
        int[] arr7 = {7, 7, 7, 7};
        test(arr7, 7);     // Should return 0, 1, 2, or 3

        // Quick summary
        System.out.println("\n=== Quick Summary ===");
        System.out.println("Tested: Basic array, edge cases, empty, negatives, duplicates");
        System.out.println("Binary search works if array is sorted!");
    }

    // Test helper function
    static void test(int[] arr, int target) {
        int result = binarySearch(arr, target);
        System.out.printf("  Search for %d → index: %d", target, result);

        // Validate result
        if (result == -1) {
            // Verify target doesn't exist
            boolean exists = false;
            for (int num : arr) {
                if (num == target) exists = true;
            }
            if (!exists) {
                System.out.println(" ✓ (correct: not found)");
            } else {
                System.out.println(" ✗ ERROR: value exists but not found!");
            }
        } else {
            // Verify index is correct
            if (result >= 0 && result < arr.length && arr[result] == target) {
                System.out.println(" ✓ (correct: found at index " + result + ")");
            } else {
                System.out.println(" ✗ ERROR: wrong index or wrong value!");
            }
        }

    }

    public  static  int binarySearch(int[] arr, int target){

        if( arr == null || arr.length == 0 || target< arr[0] || target > arr[arr.length -1] ) return -1;

        int left = 0, right = arr.length -1;

        while (left<=right){
            int mid = left + ((right - left)>>1);
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] > target){

                right = mid -1;
            }
            else{
                left = mid+1;
            }
        }
        return -1;
    }

}
