package com.coder.sanam;

public class LisUsingDP {

    public static void main(String[] args) {
        LisUsingDP obj = new LisUsingDP();
        int[] nums = {10,9,2,5,3,7,101};
        System.out.println(obj.lengthOfLis(nums));
    }

    private int lengthOfLis(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            dp[i] = 1; // Each element is an increasing subsequence of length 1
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }


}
