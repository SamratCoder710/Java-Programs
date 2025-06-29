package com.coder.sanam;

import java.util.Arrays;

public class NumberOfSubsequencesThatSatisfySum {

    public static void main(String[] args) {
        NumberOfSubsequencesThatSatisfySum numberOfSubsequencesThatSatisfySum = new NumberOfSubsequencesThatSatisfySum();
        int i = numberOfSubsequencesThatSatisfySum.numSubseq(new int[]{3, 5, 6, 7}, 9);
        System.out.println(i);
    }

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int M = 1000000007;
        int size = nums.length;
        int[] power = new int[size];
        power[0] = 1;
        for (int i = 1; i < size; i++) {
            power[i] = (power[i - 1] * 2) % M;
        }
        int i=0;
        int j= size-1;
        int sum =0;
        while(i<=j){
            if(nums[i]+nums[j]<=target){
                int diff = j-i;
                sum = (sum + power[diff])%M ;
                i++;
            }else{
                j--;
            }
        }
        return sum;
    }
}
