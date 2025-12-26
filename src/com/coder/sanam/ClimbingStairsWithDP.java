package com.coder.sanam;

import java.util.Arrays;

public class ClimbingStairsWithDP {

    int[] dp;

    public static void main(String[] args) {
        ClimbingStairsWithDP obj = new ClimbingStairsWithDP();
        int n = 4;
        System.out.println(obj.climbStairs(n));
    }

    public int climbStairs(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(0,n);
    }

    private int solve(int step,int target){
        if(step == target) return 1;
        if(step > target) return 0;

        if(dp[step] != -1) return dp[step];
        int take_1step = solve(step+1,target);
        int take_2step = solve(step+2,target);

        return dp[step] = take_1step + take_2step;
    }

    //only with one variable

    private int solveOptimized(int n){
        if(n< 0) return 0;
        if(n == 0) return 1;
        if(dp[n] != -1) return dp[n];
        return  dp[n] = solveOptimized(n-1) + solveOptimized(n-2);
    }

    //bottom up approach
    private int solveBottomUp(int n){
        dp = new int[n+1];
        if(n<=2) return n;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}

