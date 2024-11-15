package com.coder.sanam;

import java.util.Arrays;

public class MinimumFallingPathSum {
	public static int minFallingPathSum(int[][] matrix) {
		int min = Integer.MAX_VALUE;
		int[][] memo = new int[matrix.length][matrix[0].length];
		
		for (int[] cellArray : memo) {
            Arrays.fill(cellArray, Integer.MAX_VALUE);
        }
	     for(int j=0;j<matrix[0].length;j++) {
	    	 if(min > dp(0, j, matrix,memo))	{
	    		 min = dp(0,j,matrix,memo);
	    	 }
	     }
	     return min;
    }

	public static int dp(int r,int c,int[][] matrix, int[][] memo){
		
        if(memo[r][c] != Integer.MAX_VALUE) return memo[r][c];
        
        if(r == matrix.length - 1){
            memo[r][c] = matrix[r][c];
            return matrix[r][c];
        }
        
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if(c>0) {
        	left = dp(r+1,c-1,matrix,memo);
        }
        
        int straight = dp(r+1,c,matrix,memo);
        if(c< matrix[0].length - 1) {
        	right = dp(r+1,c+1,matrix,memo);
        }
        
        memo[r][c] = matrix[r][c] + Math.min(Math.min(left,right),straight);
        return memo[r][c];
    }
    
    public static void main(String[] args) {
		int[][] input = {
				{2,1,3},{6,5,4},{7,8,9}
		};
		
		int minFallingPathSum = minFallingPathSum(input);
		System.out.println(minFallingPathSum);
	}
}
