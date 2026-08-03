package com.coder.sanam;

import java.util.Arrays;

public class StoneGameI {

    static void main() {
        StoneGameI stoneGameI = new StoneGameI();
        boolean aliceWins = stoneGameI.stoneGame(new int[]{5,3,4,5});
        System.out.println(aliceWins);

        // since alice can select all odd indices or all even indices
        // what she knows the input beforehand she can check which indices will give her more score, she will choose that
        // ALICE will ALWAYS WIN !!!
        // boolean aliceWins = true;
    }

    private int size;
    private int[][] dp;

    public boolean stoneGame(int[] piles) {
        dp = new int[500][500];
        for (int[] dpArr : dp) {
            Arrays.fill(dpArr, -1);
        }
        int total = Arrays.stream(piles).sum();
        int aliceScore = solve(0, piles.length - 1, piles);
        int bobScore = total - aliceScore;
        if (aliceScore > bobScore) {
            return true;
        }
        return false;
    }

    private int solve(int i, int j, int[] piles) {

        if (i > j) {
            return 0;
        }


        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int take_left = piles[i] + Math.min(solve(i + 2, j, piles), solve(i + 1, j - 1, piles));

        int take_right = piles[j] + Math.min(solve(i + 1, j - 1, piles), solve(i, j - 2, piles));

        return dp[i][j] = Math.max(take_left, take_right);
    }
}
