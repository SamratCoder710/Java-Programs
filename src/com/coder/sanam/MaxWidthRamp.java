package com.coder.sanam;

import java.util.Stack;

public class MaxWidthRamp {

    public static void main(String[] args) {
        System.out.println(maxWidthRamp(new int[]{6,0,8,2,1,5}));
    }

    public static int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(stack.isEmpty() || nums[stack.peek()]>nums[i] ){
                stack.push(i);
            }
        }

        int maxWidth = 0;
        for(int j=n-1;j>=0;j--){
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[j]){
                maxWidth = Math.max(maxWidth,j-stack.pop());
            }
        }
        return maxWidth;
    }
}
