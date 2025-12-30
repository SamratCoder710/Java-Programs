package com.coder.sanam;

import java.util.Arrays;

public class UniquePathsII {

    int[][] dp;

    public static void main(String[] args) {
        UniquePathsII obj = new UniquePathsII();
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(obj.uniquePathsWithObstacles(obstacleGrid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        dp = new int[rows][cols];

        for (int[] k : dp) {
            Arrays.fill(k, -1);
        }
        return solve(0, 0, rows, cols, obstacleGrid);
    }

    private int solve(int r, int c, int rows, int cols, int[][] grid) {
        if (r >= rows || c >= cols || grid[r][c] == 1) {
            return 0;
        }
        if (r == rows - 1 && c == cols - 1) {
            return 1;
        }
        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        int bottom = solve(r + 1, c, rows, cols, grid);
        int right = solve(r, c + 1, rows, cols, grid);

        return dp[r][c] = bottom + right;
    }

}
