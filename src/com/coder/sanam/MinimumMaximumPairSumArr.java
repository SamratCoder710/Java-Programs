package com.coder.sanam;

import java.util.Arrays;

public class MinimumMaximumPairSumArr {

    public static void main(String[] args) {
        MinimumMaximumPairSumArr   minimumMaximumPairSumArr = new MinimumMaximumPairSumArr();
        int[] nums = {3,5,2,3};
        int result = minimumMaximumPairSumArr.minPairSum(nums);
        System.out.println(result);
    }

    public int minPairSum(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length/2;i++){
            result = Math.max(result, nums[i] + nums[nums.length - 1 - i]);
        }
        return result;
    }

}
