package com.coder.sanam;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimizeMaximumDiffOfPair {


    public static void main(String[] args) {
        MinimizeMaximumDiffOfPair minimizeMaximumDiffOfPair = new MinimizeMaximumDiffOfPair();
        int[] nums = {10,1,2,7,1,3};
        int p = 2;
        int result = minimizeMaximumDiffOfPair.minimizeMax(nums, p);
        System.out.println(result);
    }

    private boolean isValid(int mid, int[] nums,int p){
        int i =0;
        int size = nums.length;
        int countPairs  = 0;
        while(i<size-1){
            if(nums[i+1] - nums[i] <= mid){
                countPairs++;
                i+=2;
            }else{
                i++;
            }
        }
        return countPairs >= p;
    }

    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int result = 0;
        int n = nums.length;
        int l = 0;
        int r = nums[n-1] - nums[0];

        while(l<=r){
            int mid = l + (r-l)/2;
            if(isValid(mid,nums,p)){
                result = mid;
                r = mid -1;
            }else{
                l = mid + 1;
            }
        }
        return result;
    }

}
