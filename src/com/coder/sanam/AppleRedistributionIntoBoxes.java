package com.coder.sanam;

import java.util.Arrays;

public class AppleRedistributionIntoBoxes {

    private int[][] dp;
    private static final int INF = (int)1e9;

    private int solve(int idx,int appleSum, int[] capacity){
        // If all apples are placed
        if (appleSum <= 0) {
            return 0;
        }
        // No boxes left but apples still remain → invalid
        if (idx == capacity.length) {
            return INF;
        }
        if (dp[idx][appleSum] != -1) {
            return dp[idx][appleSum];
        }

        int take = 1 + solve(idx+1,appleSum - capacity[idx],capacity);
        int skip = solve(idx+1,appleSum,capacity);

        return dp[idx][appleSum] =Math.min(take,skip);

    }

    public static void main(String[] args) {
        AppleRedistributionIntoBoxes obj = new AppleRedistributionIntoBoxes();
        int[] apple = {5,5,5};
        int[] capacity = {2,4,2,7};
        System.out.println(obj.minimumBoxesDP(apple, capacity));

    }

    public int minimumBoxes(int[] apple, int [] capacity){
        int appleSum = 0;
        for(int i: apple){
            appleSum += i;
        }

        Arrays.sort(capacity);

        int idx = capacity.length - 1;
        int boxCount = 0;
        while(appleSum > 0){
            appleSum -= capacity[idx];
            boxCount++;
            idx--;
        }
        return boxCount;
    }

    public int minimumBoxesDP(int[] apple, int [] capacity){
        int appleSum = 0;
        for(int i : apple){
            appleSum += i;
        }
        dp = new int[capacity.length][appleSum + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0,appleSum,capacity);
    }
}
