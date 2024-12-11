package com.coder.sanam;

import java.util.Arrays;


public class MaximumBeautyOfArrayAfterApplyingOperation {

    public static void main(String[] args) {
        int i = maximumBeautyOptimized(new int[]{1,1,1,1}, 10);
        System.out.println(i);
    }


    //TLE
    public static int maximumBeauty(int[] nums, int k) {
        int[] arr = new int[2000000];
        for(int i: nums){
            for(int j=i-k;j<=i+k;j++){
                arr[j+1000000]++;
            }
        }

        int max = Integer.MIN_VALUE;
        for(int num : arr){
            max = Math.max(max,num);
        }
        return max;

    }

    //O(nlogn)
    public static int maximumBeautyOptimized(int[] nums, int k) {
        Arrays.sort(nums);
        int max = 0;
        for(int i=0;i<nums.length;i++){
            int x = nums[i];
            int y = x + (2*k);

            int j = binarySearch(nums,y);
            max = Math.max(max,j-i+1);
        }
        return max;

    }

    private static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int result = 0;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] <= target){
                result = mid;
                left = mid +1;
            }else{
                right = mid -1;
            }
        }
        return result;
    }
}
