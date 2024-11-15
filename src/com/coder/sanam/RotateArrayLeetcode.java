package com.coder.sanam;

import java.util.Arrays;

public class RotateArrayLeetcode {
	
	public static void rotate(int[] nums, int k) {
        int n = nums.length;
        while(k>0){
            int temp = nums[n-1];
            for(int i=n-2;i>=0;i--){
                nums[i+1] = nums[i];
            }
            nums[0] = temp;
            k--;
        } 
    }
	
	public static void rotateOptimal(int[] nums, int k) {
	       int[] res = new int[nums.length];
	       for(int i=0;i<nums.length;i++){
	           res[(i+k) % nums.length] = nums[i];
	       }
	       nums = res;
	       
	       for(int x:res) {
	    	   System.out.print(x+"::");
	       }
	    }
	
	public static void main(String[] args) {
		rotateOptimal(new int[] {1,2,3,4,5,6,7}, 3);
	}

}
