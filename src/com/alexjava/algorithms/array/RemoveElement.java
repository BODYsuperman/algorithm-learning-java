package com.alexjava.algorithms.array;

public class RemoveElement {
    public static void main(String[] args) {

        System.out.println("Remove Element Simple Test\n");

        // Test 1: Basic case - target exists in random positions
        System.out.println("Test 1: Basic array [3, 2, 2, 3] , remove value: 3");
        int[] arr1 = {3, 2, 2, 3};
        test(arr1, 3, 2);  // Expected length: 2, valid part [2,2]

        // Test 2: Special case - array with all target elements
        System.out.println("\nTest 2: All target elements [2, 2, 2] , remove value: 2");
        int[] arr2 = {2, 2, 2};
        test(arr2, 2, 0);  // Expected length: 0

        // Test 3: Special case - array with no target elements
        System.out.println("\nTest 3: No target elements [1, 2, 3] , remove value: 4");
        int[] arr3 = {1, 2, 3};
        test(arr3, 4, 3);  // Expected length: 3, array unchanged

        // Test 4: Edge case - single element array (hit/miss)
        System.out.println("\nTest 4: Single element array");
        int[] arr4 = {5};
        int[] arr5 = {5};
        test(arr4, 5, 0);  // Hit target, expected length: 0
        test(arr5, 6, 1);  // Miss target, expected length: 1

        // Test 5: Edge case - two elements array
        System.out.println("\nTest 5: Two elements array [1, 4] , remove value: 4");
        int[] arr6 = {1, 4};
        test(arr6, 4, 1);  // Expected length: 1, valid part [1]

        // Test 6: Edge case - empty array & null array
        System.out.println("\nTest 6: Empty array & Null array , remove value: 1");
        int[] arr7 = {};
        test(arr7, 1, -1); // Empty array, expected return: -1
        test(null, 1, -1); // Null array, expected return: -1

        // Quick test summary
        System.out.println("\n=== Quick Summary ===");
        System.out.println("Tested: Basic case, all target, no target, single element, two elements, empty/null array");
        System.out.println("Remove Element works correctly (in-place array modification)!");
    }

    // Test helper method: execute test, validate result and print detail
    // Parameters: nums - test array, val - value to remove, expectedLen - expected valid length
    static void test(int[] nums, int val, int expectedLen) {
        // Copy original array for display (avoid in-place modification impact)
        int[] originalNums = null;
        if (nums != null) {
            originalNums = new int[nums.length];
            System.arraycopy(nums, 0, originalNums, 0, nums.length);
        }

        // Call core method to get actual result
        int actualLen = removeElement(nums, val);

        // Print basic test info
        System.out.printf("  Remove %d → Expected len: %d, Actual len: %d", val, expectedLen, actualLen);

        // Step 1: Check if the return length is correct
        boolean isLenCorrect = (actualLen == expectedLen);
        // Step 2: Check if the array's valid part has no target value (in-place check)
        boolean isArrayCorrect = true;
        if (nums != null && nums.length > 0 && actualLen > 0) {
            for (int i = 0; i < actualLen; i++) {
                if (nums[i] == val) { // Valid part should not contain target value
                    isArrayCorrect = false;
                    break;
                }
            }
        }

        // Print final test result with ✓/✗
        if (isLenCorrect && isArrayCorrect) {
            System.out.println(" ✓ (correct)");
            // Print valid part of the modified array (for verification)
            if (nums != null && actualLen > 0) {
                System.out.print("    Modified array valid part: [");
                for (int i = 0; i < actualLen; i++) {
                    System.out.print(nums[i]);
                    if (i < actualLen - 1) System.out.print(", ");
                }
                System.out.println("]");
            }
        } else {
            System.out.println(" ✗ ERROR: Wrong length or invalid array modification!");
            // Print original array for error debugging
            if (originalNums != null) {
                System.out.print("    Original array: [");
                for (int i = 0; i < originalNums.length; i++) {
                    System.out.print(originalNums[i]);
                    if (i < originalNums.length - 1) System.out.print(", ");
                }
                System.out.println("]");
            }
        }

    }

    public static  int removeElement(int[] nums, int val) {
        //note that array is a block of continuous address containers

        if(nums == null || nums.length==0) return  -1;
        //fast index scan across the whole entire array
        int slowIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[slowIndex++] = nums[i];
            }
        }
        return slowIndex;
    }
}
