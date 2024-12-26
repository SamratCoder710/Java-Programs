package com.coder.sanam;

public class TargetSumDP {

    public static void main(String[] args) {
        TargetSumDP targetSumDP = new TargetSumDP();
        int[] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println(targetSumDP.findTargetSumWays(nums,target));
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][2001];
        return helper(dp,0,0,target,nums);
    }

    private int helper(int[][] dp,int idx, int sum,int target,int[] nums){
        if(idx == nums.length){
            return sum == target?1:0;
        }
        if(dp[idx][sum+1000] != 0) return dp[idx][sum + 1000];

        int add = helper(dp,idx+1,sum+nums[idx],target,nums);
        int subtract = helper(dp,idx+1,sum-nums[idx],target,nums);

        return dp[idx][sum + 1000] = add + subtract;
    }
}
