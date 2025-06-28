package com.coder.sanam;

import java.util.Arrays;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class MaximizeSUmOfArrayAfterKNegations {

    public static void main(String[] args) {
        MaximizeSUmOfArrayAfterKNegations maximizeSUmOfArrayAfterKNegations = new MaximizeSUmOfArrayAfterKNegations();
        int i = maximizeSUmOfArrayAfterKNegations.largestSumAfterKNegations_optimal(new int[]{-8, 3, -5, -3, -5, -2}, 6);
        System.out.println(i);
    }

    public int largestSumAfterKNegations_brute(int[] nums, int k) {
        Arrays.sort(nums);
        int size = nums.length;
        int sum = 0;
        int idx = 0;
        while(k>0 && idx<size){
            if(nums[idx] < 0){
                nums[idx] = -nums[idx];
                k--;
            }else if(nums[idx] == 0){
                k = 0;
            }else{
                break;
            }
            idx++;

        }
        Arrays.sort(nums);
        idx = 0;
        while(k > 0){
            sum += k%2==0?nums[idx]:-nums[idx];
            k = 0;
            idx++;
        }
        while(idx < size){
            sum += nums[idx];
            idx++;
        }

        return sum;
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        int absSum = 0;
        int countNegatives = 0;
        boolean hasZero = false;
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            if(num == 0){
                hasZero = true;
            }else if(num < 0){
                countNegatives++;
            }else{
                min = min(num,min);
            }
            absSum += abs(num);
        }
        if(k - countNegatives == 0){
            return absSum;
        } else if(k - countNegatives < 0){
            Arrays.sort(nums);
            for(int i=k;i<countNegatives;i++){
                absSum -= 2*(-nums[i]);
            }
            return absSum;
        }else{
            if (!hasZero) {
                int value = k - countNegatives;
                if (value % 2 == 1) {
                    Arrays.sort(nums);
                    for (int i = 0; i < countNegatives; i++) {
                        min = Math.min(min,-nums[i]);
                    }
                    absSum -= 2 * min;
                }


            }
            return absSum;
        }
    }

    public int largestSumAfterKNegations_optimal(int[] nums, int k) {
        int[] numbers = new int[201];
        int sum = 0;
        int maxAbs = 0;
        for (int n: nums) {
            maxAbs = Math.max(maxAbs, Math.abs(n));
            numbers[100 + n]++;
            sum += n;
        }
        if (maxAbs == 0) {
            return 0;
        }
        while (k-- != 0) {
            int i = 100 - maxAbs;
            while (numbers[i] == 0) {
                i++;
            }
            numbers[i]--;
            numbers[200 - i]++;
            sum -= 2 * (i - 100);
        }
        return sum;
    }
}
