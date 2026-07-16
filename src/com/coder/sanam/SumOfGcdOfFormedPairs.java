package com.coder.sanam;

import java.util.Arrays;

public class SumOfGcdOfFormedPairs {

    static void main() {
        SumOfGcdOfFormedPairs sumOfGcdOfFormedPairs = new SumOfGcdOfFormedPairs();
        long result = sumOfGcdOfFormedPairs.gcdSum(new int[]{2, 5, 6, 9, 10});
        System.out.println(result);
    }

    public long gcdSum(int[] nums) {
        int max = nums[0];
        int n = nums.length;
        int[] prefixGcd = new int[n];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            prefixGcd[i] = gcd(nums[i], max);
        }

        long sum = 0;
        Arrays.sort(prefixGcd);
        for (int i = 0; i < n / 2; i++) {
            sum += gcd(prefixGcd[i], prefixGcd[n - 1 - i]);
        }
        return sum;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return gcd(b, a % b);
    }

}
