package com.coder.sanam.ArraySumImplementation;

public class SequentialArraySum {

    private int[] nums;

    public SequentialArraySum(int[] nums) {
        this.nums = nums;
    }

    public int[] getNums() {
        return nums;
    }

    public int getSum(){
        int sum = 0;
        for(int i = 0;i< nums.length;i++){
            sum += nums[i];
        }
        return sum;
    }
}
