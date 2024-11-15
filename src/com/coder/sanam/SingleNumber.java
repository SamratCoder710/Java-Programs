package com.coder.sanam;

import java.util.Arrays;

public class SingleNumber {
	
	//Efficient solution
	//use XOR for all arrays elements as element XOR element results in 0 leaving behind single element 
	public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if(nums.length == 1) return nums[0];
        for(int i=0;i<nums.length-2;i++){
        	System.out.println(nums[i+1] - nums[i]);
        	System.out.println(nums[i+2]- nums[i+1]);
            if(nums[i+1] - nums[i]  > 0 && nums[i+2]- nums[i+1]  > 0){
                return nums[i+1];
            }
        }
        
        if(nums[1]-nums[0] > 0) return nums[0];
        if(nums[nums.length-1]-nums[nums.length-2] > 0) return nums[nums.length-1];
        return 0;
    }
	
	public static void main(String[] args) {
		int singleNumber = singleNumber(new int[] {4,1,2,1,2});
		System.out.println(singleNumber);
	}

}
