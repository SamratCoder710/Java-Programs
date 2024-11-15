package com.coder.sanam;

import java.util.Arrays;

public class CountNumberOfFairs {

    public static void main(String[] args) {
        long l = countFairPairs(new int[]{0, 1, 7, 4, 4, 5}, 3, 6);
        System.out.println(l);
    }

    public static long countFairPairs(int[] nums, int lower, int upper) {
        long res = 0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            int low = lowerBound(nums,i+1,nums.length,lower-nums[i]);
            int up = upperBound(nums,i+1,nums.length,upper-nums[i]);
            res += (long)up-low;
        }
        return res;
    }

    //UpperBound
    private static int upperBound(int[] nums, int start, int end, int target) {
        while(start<end){
            int mid = start+(end-start)/2;
            if(nums[mid] > target) end = mid;
            else start = mid+1;
        }
        return start;
    }

    private static int lowerBound(int[] nums, int start, int end, int target) {
        while(start<end){
            int mid = start+(end-start)/2;
            if(nums[mid] >= target) end = mid;
            else start = mid+1;
        }
        return start;
    }


}
