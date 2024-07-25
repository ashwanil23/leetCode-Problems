// Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.

// Example 1:

// Input: nums = [1,4,3,2]
// Output: 4
// Explanation: All possible pairings (ignoring the ordering of elements) are:
// 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
// 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
// 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
// So the maximum possible sum is 4.

// Example 2:

// Input: nums = [6,2,6,5,1,2]
// Output: 9
// Explanation: The optimal pairing is (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9.
 

// Constraints:

// 1 <= n <= 10^4
// nums.length == 2 * n
// -10^4 <= nums[i] <= 10^4

package com.directory.Array;

import java.util.Arrays;

public class ArrayPartition {
//    This logic will take 12ms time and the Time Complexity is O(NlogN) because of Arrays.sort() method.
//    public static int arrayPairSum(int[] nums) {
//        Arrays.sort(nums);
//        int sum = 0;
//        for(int i = 0; i < nums.length; i += 2){
//            sum += nums[i];
//        }
//        return sum;
//    }


    // Use count sort instead of Array.sort() for the best time complexity O(N)
    public static int arrayPairSum(int[] nums){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        int[] countArray = new int[max - min + 1];
        int j = 0;

        for (int num : nums) {
            countArray[num - min]++;
        }

        for (int i = 0; i < countArray.length; i++) {
            while (countArray[i] > 0) {
                nums[j] = i + min;
                countArray[i]--;
                j++;
            }
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] myArray = {1,4,3,2};
        System.out.println(arrayPairSum(myArray));
    }
}
