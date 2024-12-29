package com.coder.sanam;

import java.util.Arrays;

public class NumberOfWaysToFormTargetFromDict {

    private static final int MOD = 1_000_000_007;
    private int k; // Length of each word
    private int[][] memo;

    public int numWays(String[] words, String target) {
        k = words[0].length();
        int[][] freq = new int[26][k];
        memo = new int[1001][1001]; // Initialize memo array with -1
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        // Calculate the frequency of each character in each column
        for (int col = 0; col < k; col++) {
            for (String word : words) {
                char ch = word.charAt(col);
                freq[ch - 'a'][col]++;
            }
        }

        return solveWays(0, 0, freq, target);
    }

    private int solveWays(int i, int j, int[][] freq, String target) {
        if (i == target.length()) {
            return 1; // Successfully formed the target
        }
        if (j == k) {
            return 0; // Exhausted all columns
        }
        if (memo[i][j] != -1) {
            return memo[i][j]; // Return cached result
        }

        // Skip current column
        int notTake = solveWays(i, j + 1, freq, target);

        // Take current column (if character matches)
        int take = 0;
        char ch = target.charAt(i);
        if (freq[ch - 'a'][j] > 0) {
            take = (int) ((long) freq[ch - 'a'][j] * solveWays(i + 1, j + 1, freq, target) % MOD);
        }

        // Cache and return the result
        memo[i][j] = (notTake + take) % MOD;
        return memo[i][j];
    }

    public static void main(String[] args) {
        NumberOfWaysToFormTargetFromDict ways = new NumberOfWaysToFormTargetFromDict();
        int result = ways.numWays(new String[]{"acca", "bbbb", "caca"}, "aba");
        System.out.println(result); // Expected output: 6
    }
}
