package com.coder.sanam;

import java.util.Arrays;

public class MinDiffBetweenHighLow {

    public static void main(String[] args) {
        MinDiffBetweenHighLow minDiffBetweenHighLow = new MinDiffBetweenHighLow();
        int[] nums = {9,4,1,7};
        int k = 2;
        int result = minDiffBetweenHighLow.minimumDifference(nums, k);
        System.out.println(result);
    }

    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        int result = Integer.MAX_VALUE;
        if(n == 1) return 0;
        Arrays.sort(nums);

        for(int i=0;i+k <= n;i++){
            result = Math.min(result , nums[i+k-1] - nums[i]);
        }
        return result;
    }
}
