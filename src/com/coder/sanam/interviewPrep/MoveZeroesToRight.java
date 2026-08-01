package com.coder.sanam.interviewPrep;

import java.util.Arrays;

public class MoveZeroesToRight {

    static void main() {
        int [] nums = new int[]{1,0,4,5,9,0,13,0,15};

        moveZeroesToRight(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void moveZeroesToRight(int[] nums) {
        int insertPos = 0;
        int n = nums.length;
        for(int num : nums){
            if(num != 0){
                nums[insertPos++] = num;
            }
        }

        int lastNonZeroIdx = insertPos;
        while(insertPos < n){
            nums[insertPos++] = 0;
        }

        System.out.println("No of Zeroes shifted::"+ (n-lastNonZeroIdx));

    }


}
