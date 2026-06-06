package com.coder.sanam;

import java.util.Arrays;

public class LeftAndRightSumDifferences {
    public static void main(String[] args) {
        LeftAndRightSumDifferences leftAndRightSumDifferences = new LeftAndRightSumDifferences();
        int[] res = leftAndRightSumDifferences.leftRightDifference(new int[]{10, 4, 8, 3});
        System.out.println(Arrays.toString(res));
    }

    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 0;
        right[n - 1] = 0;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + nums[i - 1];
        }
        int[] result = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + nums[i + 1];
            result[i] = Math.abs(left[i] - right[i]);
        }

        result[n - 1] = Math.abs(left[n - 1] - right[n - 1]);
        return result;
    }

}
