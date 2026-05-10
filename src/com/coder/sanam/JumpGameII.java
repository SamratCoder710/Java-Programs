package com.coder.sanam;

import java.util.Arrays;

public class JumpGameII {

    public static void main(String[] args) {

        JumpGameII jumpGameII = new JumpGameII();

        int result = jumpGameII.jump(new int[]{2,3,0,1,4});

        System.out.println(result);
    }

    private int n;
    private int[] dp;

    public int jump(int[] nums) {

        n = nums.length;

        dp = new int[n];

        // -1 means not computed yet
        Arrays.fill(dp, -1);

        return solve(0, nums);
    }

    private int solve(int i, int[] nums) {

        // reached last index
        if (i == n - 1) {
            return 0;
        }

        // already computed
        if (dp[i] != -1) {
            return dp[i];
        }

        int result = Integer.MAX_VALUE;

        for (int j = 1; j <= nums[i]; j++) {

            if (i + j < n) {

                int subProblem = solve(i + j, nums);

                // avoid overflow
                if (subProblem != Integer.MAX_VALUE) {
                    result = Math.min(result, 1 + subProblem);
                }
            }
        }

        dp[i] = result;

        return dp[i];
    }
}