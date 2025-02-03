package com.coder.sanam;

public class LongestStrictlyIncreasingOrStrictlyDecreasing {

    public static void main(String[] args) {
        LongestStrictlyIncreasingOrStrictlyDecreasing longestStrictlyIncreasingOrStrictlyDecreasing = new LongestStrictlyIncreasingOrStrictlyDecreasing();
        int i = longestStrictlyIncreasingOrStrictlyDecreasing.longestMonotonicSubarray(new int[]{1, 4, 3, 3, 2});
        System.out.println(i);
    }

    public int longestMonotonicSubarray(int[] nums) {
        int incLen = 1;
        int decLen = 1;
        int maxLen = 1;
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i+1]>nums[i]){
                incLen++;
                decLen=1;
            }else if(nums[i+1]<nums[i]){
                decLen++;
                incLen=1;
            }else{
                incLen=1;
                decLen=1;
            }
            maxLen = Math.max(maxLen,Math.max(incLen,decLen));
        }

        return maxLen;
    }
}
