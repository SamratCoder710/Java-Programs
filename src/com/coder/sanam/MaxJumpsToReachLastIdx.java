package com.coder.sanam;

import java.util.Arrays;

public class MaxJumpsToReachLastIdx {
    int[] t = new int[1001];

    public static void main(String[] args) {
        MaxJumpsToReachLastIdx maxJumpsToReachLastIdx = new MaxJumpsToReachLastIdx();
        int result = maxJumpsToReachLastIdx.maximumJumps(new int[]{1, 3, 6, 4, 1, 2}, 2);
        System.out.println(result);
    }

    public int maximumJumps(int[] nums, int target) {
        Arrays.fill(t, Integer.MIN_VALUE);
        int n = nums.length;
        int res = solve(0, n, nums, target);
        return res < 0 ? -1 : res;
    }

    private int solve(int i, int n, int[] nums, int target) {
        if (i == n - 1) {
            return t[i] = 0;
        }

        if (t[i] != Integer.MIN_VALUE) {
            return t[i];
        }
        int result = Integer.MIN_VALUE;
        for (int j = i + 1; j < n; j++) {
            if (Math.abs(nums[j] - nums[i]) <= target) {
                int temp = 1 + solve(j, n, nums, target);
                result = Math.max(result, temp);
            }
        }

        return t[i] = result;
    }

}
