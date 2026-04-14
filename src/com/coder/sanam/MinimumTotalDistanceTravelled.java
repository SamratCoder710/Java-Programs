package com.coder.sanam;

import java.util.*;

public class MinimumTotalDistanceTravelled {

    public static void main(String[] args) {
        MinimumTotalDistanceTravelled  minimumTotalDistanceTravelled = new MinimumTotalDistanceTravelled();
        long l = minimumTotalDistanceTravelled.minimumTotalDistance(List.of(0, 4, 6), new int[][]{{2, 2}, {6, 2}});
        System.out.println(l);

    }

    private long[][] dp;

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        robot = robot.stream().sorted().toList();
        List<Integer> factoryPositions = new ArrayList<>();
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        for(int [] fac : factory){
            while(fac[1] > 0){
                factoryPositions.add(fac[0]);
                fac[1]--;
            }
        }

        dp = new long[robot.size() + 1][factoryPositions.size() + 1];
        for (long[] row : dp) Arrays.fill(row, -1);

        return solve(0,0,robot,factoryPositions);
    }

    private long solve(int i, int j,List<Integer> robot, List<Integer> factoryPositions) {
        if(i >= robot.size() ){
            return 0;
        }
        if(j >= factoryPositions.size()){
            return (long)1e18; // Not extreme value for overflow
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        long take = Math.abs(robot.get(i) - factoryPositions.get(j)) + solve(i+1,j+1, robot,factoryPositions);
        long skip = solve(i,j+1, robot,factoryPositions);
        return dp[i][j] = Math.min(take,skip);
    }


}
