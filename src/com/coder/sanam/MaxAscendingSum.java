package com.coder.sanam;

public class MaxAscendingSum {

    public static void main(String[] args) {
        MaxAscendingSum maxAscendingSum = new MaxAscendingSum();
        int i = maxAscendingSum.maxAscendingSum(new int[]{10, 20, 30, 5, 10, 50});
        System.out.println(i);
    }

    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int sum = nums[0];
        int max = sum;
        for(int i=0;i<n-1;i++){
            if(nums[i+1]>nums[i]){
                sum += nums[i+1];
            }else {
                sum = nums[i+1];
            }
            max = Math.max(max,sum);
        }
        return max;
    }
}
