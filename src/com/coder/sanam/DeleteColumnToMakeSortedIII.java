package com.coder.sanam;

public class DeleteColumnToMakeSortedIII {

    public static void main(String[] args) {
        DeleteColumnToMakeSortedIII obj = new DeleteColumnToMakeSortedIII();
        String[] strs = {"babca","bbazb"};
        System.out.println(obj.minDeletionSize(strs));
    }



    public int minDeletionSize(String[] strs) {
        int cols = strs[0].length();

        int[] dp = new int[cols];
        int maxKept = 0;

        for (int i = 0; i < cols; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (isSorted(strs, j, i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxKept = Math.max(maxKept, dp[i]);
        }

        return cols - maxKept;
    }

    private boolean isSorted(String[] strs, int j, int i) {
        for (String s : strs) {
            if (s.charAt(j) > s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

}
