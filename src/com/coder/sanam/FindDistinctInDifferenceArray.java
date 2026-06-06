package com.coder.sanam;

import java.util.Arrays;

public class FindDistinctInDifferenceArray {

    public static void main(String[] args) {
        FindDistinctInDifferenceArray findDistinctInDifferenceArray = new FindDistinctInDifferenceArray();
        int[] result = findDistinctInDifferenceArray.distinctDifferenceArray(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(result));
    }

    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] prefixDistinct = new int[n];
        int[] suffixDistinct = new int[n];

        boolean[] seen = new boolean[51];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!seen[nums[i]]) {
                seen[nums[i]] = true;
                count++;
            }
            prefixDistinct[i] = count;
        }
        seen = new boolean[51];
        count = 0;
        for (int j = n - 1; j >= 0; j--) {
            if (!seen[nums[j]]) {
                seen[nums[j]] = true;
                count++;
            }
            suffixDistinct[j] = count;
        }

        int[] res = new int[n];

        for (int i = 0; i < n - 1; i++) {
            res[i] = prefixDistinct[i] - suffixDistinct[i + 1];
        }
        res[n - 1] = prefixDistinct[n - 1];
        return res;
    }
}
