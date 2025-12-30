package com.coder.sanam;

import java.util.Arrays;

public class MinimumPathSum {

    public static void main(String[] args) {
        MinimumPathSum obj = new MinimumPathSum();
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(obj.minPathSum(grid));
    }

    int[][] dp;
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        dp = new int[rows][cols];

        for(int[] k: dp){
            Arrays.fill(k,-1);
        }
        return solve(0, 0, rows,cols,grid);
    }

    private int solve(int r,int c,int rows,int cols,int[][] grid){
        if(r >= rows || c >= cols){
            return Integer.MAX_VALUE;
        }

        if(r == rows-1 && c == cols-1){
            return grid[r][c];
        }
        if(dp[r][c] != -1){
            return dp[r][c];
        }

        int right = solve(r,c+1,rows,cols,grid);
        int down = solve(r+1,c,rows,cols,grid);

        return dp[r][c] = grid[r][c] + Math.min(right,down);
    }
}
