package com.coder.sanam.misc.medium;

import java.util.Arrays;

public class PredictTheWinner {

    static void main() {
        PredictTheWinner predictTheWinner = new PredictTheWinner();
        boolean p1Wins = predictTheWinner.predictTheWinner(new int[]{1, 1});
        System.out.println(p1Wins);
    }

    // Difference p1Score - p2Score
    private int[][] memo;

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        memo = new int[23][23];

        for (int[] dp : memo) {
            Arrays.fill(dp, -1);
        }
        int diff = solve(0, n - 1, nums);
        ;
        return diff >= 0;
    }

    private int solve(int i, int j, int[] nums) {

        if (i > j) {
            return 0;
        }

        if (i == j) {
            return nums[i];
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int take_left = nums[i] - solve(i + 1, j, nums);
        int take_right = nums[j] - solve(i, j - 1, nums);

        return memo[i][j] = Math.max(take_left, take_right);
    }


    /*

    // p1Score
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int p1 = solve(0, n - 1, nums);
        int total = Arrays.stream(nums).sum();
        return p1 >= total - p1;
    }

    private int solve(int i, int j, int[] nums) {

        if (i > j) {
            return 0;
        }
        int take_left = nums[i] + Math.min(
                solve(i + 2, j, nums),
                solve(i + 1, j - 1, nums)
        );

        int take_right = nums[j] + Math.min(
                solve(i + 1, j - 1, nums),
                solve(i, j - 2, nums)
        );

        return Math.max(take_left, take_right);
    }

    */


}
