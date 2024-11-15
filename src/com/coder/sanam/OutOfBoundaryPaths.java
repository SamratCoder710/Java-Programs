package com.coder.sanam;

import java.util.Arrays;

public class OutOfBoundaryPaths {
	
	private static int M;
    private static int N;
    private static final int MOD = 1000000000 + 7;
    private static int[][] directions = {
        {0,1},{0,-1},{1,0},{-1,0}
    };
    private static int[][][] t;

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        M = m;
        N = n;
        t = new int[51][51][51];
        for (int i = 0; i < 51; i++) {
            for (int j = 0; j < 51; j++) {
                Arrays.fill(t[i][j], -1);
            }
        }
        return dp(startRow,startColumn,maxMove);
    }

    public static int dp(int r,int c,int maxMove){
    	if(r<0 || r>=M || c<0 ||c>=N) return 1;

        if(maxMove <= 0 ) return 0;
        
        if(t[r][c][maxMove] != -1 ) {
        	return t[r][c][maxMove];
        }
        
        int result = 0;
        for(int[] pair :directions){
            int k = pair[0];
            int l = pair[1];
            result = (result + dp(r+k,c+l,maxMove-1) ) % MOD;
        }
        return t[r][c][maxMove] = result;
    }
    
    public static void main(String[] args) {
		int findPaths = findPaths(2, 2, 2, 0, 0);
		System.out.println(findPaths);
	}
    

}
