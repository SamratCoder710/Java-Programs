package com.coder.sanam;

import java.util.Arrays;

public class NumberOfSubSequenceWithEqualGCD {

    static void main() {
        NumberOfSubSequenceWithEqualGCD numberOfSubSequenceWithEqualGCD = new NumberOfSubSequenceWithEqualGCD();
        int i = numberOfSubSequenceWithEqualGCD.subsequencePairCount(new int[]{1, 2, 3, 4});
        System.out.println(i);
    }

    private static final int MOD = 1_000_000_007;
    private int[][][] dp;
    private int n;

    public int subsequencePairCount(int[] nums) {
        n = nums.length;
        dp = new int[n + 1][201][201];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= 200; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(nums, 0, 0, 0);
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return gcd(b, a % b);
    }

    private int solve(int[] nums, int idx, int seq1, int seq2) {


        if (idx == nums.length) {
            boolean bothNotEmpty = seq1 != 0 && seq2 != 0;
            boolean gcdEqual = seq1 == seq2;

            return bothNotEmpty && gcdEqual ? 1 : 0;
        }

        if (dp[idx][seq1][seq2] != -1) {
            return dp[idx][seq1][seq2];
        }
        long ans = 0;
        ans = (ans + solve(nums, idx + 1, seq1, seq2)) % MOD;
        ans = (ans + solve(nums, idx + 1, gcd(seq1, nums[idx]), seq2)) % MOD;
        ans = (ans + solve(nums, idx + 1, seq1, gcd(seq2, nums[idx]))) % MOD;

        return dp[idx][seq1][seq2] = (int) ans;
    }

}
