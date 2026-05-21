package com.coder.sanam;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestCommonPrefix {

    public static void main(String[] args) {
        LengthOfLongestCommonPrefix lengthOfLongestCommonPrefix = new LengthOfLongestCommonPrefix();
        int result = lengthOfLongestCommonPrefix.longestCommonPrefix(new int[]{123, 456, 789}, new int[]{12, 45, 78});
        System.out.println(result);
    }


    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr1) {
            while (num != 0) {
                set.add(num);
                num /= 10;
            }
        }

        int max = 0;
        for (int num : arr2) {
            while (num != 0) {
                int digits = countDigits(num);
                if (set.contains(num)) {
                    max = Math.max(max, digits);
                }
                num /= 10;
            }
        }
        return max;
    }

    private int countDigits(int num) {
        int digits = 0;
        while (num != 0) {
            digits++;
            num /= 10;
        }
        return digits;
    }

}
