package com.coder.sanam.ArraySumImplementation;

import java.util.Arrays;

public class ParallelWorker extends Thread{

    private int[] nums ;

    private int sum;
    private int low;
    private int high;

    public ParallelWorker(int[] nums,int sum,int low,int high){
        this.nums = nums;
        this.sum = sum;
        this.low = low;
        this.high = high;
    }

    @Override
    public String toString() {
        return "ParallelWorker{" +
                "nums=" + Arrays.toString(nums) +
                ", sum=" + sum +
                ", low=" + low +
                ", high=" + high +
                '}';
    }

    @Override
    public void run() {
        for (int i=low ;i<high;i++) {
            sum += nums[i];
        }
    }

    public int getSum(){
        return sum;
    }
}
