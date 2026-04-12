package com.coder.sanam;

import java.util.*;

public class MinDistToTypeUsingTwoFingers {
    // Top-down DP approach for minimum distance to type a word using two fingers
    public int minimumDistanceDP(String word) {
        int n = word.length();
        // dp[i][f1][f2]: min cost to type from i, with finger1 at f1, finger2 at f2
        // f1, f2: 0-25 for 'A'-'Z', 26 means not placed yet
        Integer[][][] memo = new Integer[n][27][27];
        return dfs(word, 0, 26, 26, memo);
    }

    // Helper to get distance between two chars (or from nowhere)
    private int dist(char from, char to) {
        if (from == 0) return 0; // not placed yet
        int f = from - 'A', t = to - 'A';
        int x1 = f / 6, y1 = f % 6;
        int x2 = t / 6, y2 = t % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    private int dfs(String word, int i, int f1, int f2, Integer[][][] memo) {
        if (i == word.length()) return 0;
        if (memo[i][f1][f2] != null) return memo[i][f1][f2];
        char c = word.charAt(i);
        int idx = c - 'A';
        // Option 1: move finger 1 to c
        int cost1 = (f1 == 26 ? 0 : dist((char)('A'+f1), c)) + dfs(word, i+1, idx, f2, memo);
        // Option 2: move finger 2 to c
        int cost2 = (f2 == 26 ? 0 : dist((char)('A'+f2), c)) + dfs(word, i+1, f1, idx, memo);
        int res = Math.min(cost1, cost2);
        memo[i][f1][f2] = res;
        return res;
    }

    public static void main(String[] args) {
        MinDistToTypeUsingTwoFingers minDistToTypeUsingTwoFingers = new MinDistToTypeUsingTwoFingers();
        int dpResult = minDistToTypeUsingTwoFingers.minimumDistanceDP("TUGR");
        System.out.println("DP result: " + dpResult);
    }


}
