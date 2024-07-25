/*
An array is monotonic if it is either monotone increasing or monotone decreasing.

An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].

Given an integer array nums, return true if the given array is monotonic, or false otherwise.



Example 1:

Input: nums = [1,2,2,3]
Output: true
Example 2:

Input: nums = [6,5,4,4]
Output: true
Example 3:

Input: nums = [1,3,2]
Output: false


Constraints:

1 <= nums.length <= 105
-105 <= nums[i] <= 105
*/

package com.directory.Array;

public class MonotonicArray {
    public static boolean isMonotonic(int[] nums) {
        int i = 0;
        if(nums[0] > nums[nums.length-1]){
            while(i < nums.length-1){
                if(nums[i] < nums[i+1]){
                    return false;
                }
                i++;
            }
        }else{
            i = 0;
            while(i < nums.length-1){
                if(nums[i] > nums[i+1]){
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] myArray = {1,3,2};
        if (isMonotonic(myArray)){
            System.out.println("Monotonic");
        }else{
            System.out.println("not Monotonic");
        }
    }
}
