package com.coder.sanam;

public class CanJumpInterview150 {

    public static void main(String[] args) {
        canJump(new int[]{3,2,1,0,4});
    }

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] jumpP = new boolean[n];
        jumpP[0] = true;
        for(int i=0;i<n;i++){
            for(int k=1;k<=nums[i];k++){
                if(i+k<n && jumpP[i]){
                    jumpP[i+k] = true;
                }

            }
        }
        return jumpP[n-1];
    }
}

