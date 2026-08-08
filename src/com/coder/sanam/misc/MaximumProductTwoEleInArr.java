package com.coder.sanam.misc;

import java.util.Arrays;

public class MaximumProductTwoEleInArr {

    public static void main(String[] args) {
        MaximumProductTwoEleInArr obj = new MaximumProductTwoEleInArr();
        int[] nums = {3, 4, 5, 2};
        System.out.println(obj.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int maxNum = 0;
        int secondMaxNum = 0;
        for (int num : nums) {
            if (num > maxNum) {
                secondMaxNum = maxNum;
                maxNum = num;
            } else if (num <= maxNum && num > secondMaxNum) {
                secondMaxNum = num;
            }
        }

        return (maxNum - 1) * (secondMaxNum - 1);
    }

    public int maxProductBruteForce(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        return (nums[n - 1] - 1) * (nums[n - 2] - 1);
    }
}
