package com.coder.sanam;

import java.util.HashSet;
import java.util.Set;

public class MaxUniqueSubArraySumAfterDeletion {

    public static void main(String[] args) {
        MaxUniqueSubArraySumAfterDeletion maxUniqueSubArraySumAfterDeletion = new MaxUniqueSubArraySumAfterDeletion();
        int i = maxUniqueSubArraySumAfterDeletion.maxSum(new int[]{1, 2, 3, 4, 5});
        System.out.println(i);
    }

    public int maxSum(int[] nums) {
        boolean allNegative = true;
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            if(num >= 0){
                allNegative = false;
            }
            if(num > max){
                max = num;
            }
        }
        if(allNegative) return max;

        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int sum = 0;
        for(int s: set){
            if(s>0){
                sum += s;
            }
        }
        return sum;
    }
}
