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
