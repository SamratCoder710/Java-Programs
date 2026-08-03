package com.coder.sanam;

import java.util.Arrays;

public class StoneGameIII {

    static void main() {
        StoneGameIII stoneGame = new StoneGameIII();
        String result = stoneGame.stoneGameIII(new int[]{1,2,3,7});
        System.out.println(result);
    }

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;


        // Memoization array: memo[i] will store the max score Player 1 can get from index i to the end
        Integer[] memo = new Integer[n];

        int p1 = solve(0, stoneValue, memo);
        int total = Arrays.stream(stoneValue).sum();


        if (p1 > total - p1) {
            return "Alice";
        } else if (p1 < total - p1) {
            return "Bob";
        }
        return "Tie";
    }

    private int solve(int i, int[] stoneValue, Integer[] memo) {
        int n = stoneValue.length;
        if (i >= n) {
            return 0;
        }

        if (memo[i] != null) {
            return memo[i];
        }


        int take_1 = stoneValue[i] + Math.min(
                solve(i + 2, stoneValue, memo),
                Math.min(
                        solve(i + 3, stoneValue, memo),
                        solve(i + 4, stoneValue, memo)
                )
        );

        int take_2 = Integer.MIN_VALUE;
        int take_3 = Integer.MIN_VALUE;

        if (i + 1 < n) {
            take_2 = stoneValue[i] + stoneValue[i + 1] +
                    Math.min(
                            solve(i + 3, stoneValue, memo),
                            Math.min(
                                    solve(i + 4, stoneValue, memo),
                                    solve(i + 5, stoneValue, memo)
                            )
                    );
        }

        if (i + 2 < n) {
            take_3 = stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] +
                    Math.min(
                            solve(i + 4, stoneValue, memo),
                            Math.min(
                                    solve(i + 5, stoneValue, memo),
                                    solve(i + 6, stoneValue, memo)
                            )
                    );
        }

        return memo[i] = Math.max(
                take_1,
                Math.max(
                        take_2,
                        take_3
                )
        );

    }
}
