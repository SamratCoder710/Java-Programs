package com.coder.sanam;

public class MinOpsToMakeAllEleDivThree {

    public static void main(String[] args) {
        MinOpsToMakeAllEleDivThree obj = new MinOpsToMakeAllEleDivThree();
        int[] nums = {1,2,3,4};
        System.out.println(obj.minimumOperations(nums));
    }

    public int minimumOperations(int[] nums) {
        int count = 0;
        for(int num: nums){
            count += (num % 3 == 2)? 1: num%3;
        }
        return count;
    }


}
