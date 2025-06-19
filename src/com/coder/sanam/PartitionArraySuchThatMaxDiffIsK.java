package com.coder.sanam;

import java.util.Arrays;

public class PartitionArraySuchThatMaxDiffIsK {


    public static void main(String[] args) {
        PartitionArraySuchThatMaxDiffIsK partitionArraySuchThatMaxDiffIsK = new PartitionArraySuchThatMaxDiffIsK();
        int i = partitionArraySuchThatMaxDiffIsK.partitionArray(new int[]{3, 6, 1, 2, 5}, 2);
        System.out.println(i);
    }

    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);

        int count = 1;//first subsequence
        int minVal = nums[0];

        for(int i=1;i<nums.length;i++){
            if(nums[i] - minVal > k ){
                count++;
                minVal = nums[i];
            }
        }
        return count;
    }

}
