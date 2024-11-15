package com.coder.sanam;

public class MaxProductSubarray {
	
	    public static int maxProduct(int[] nums) {
	        int index = 0;
	        int maxProduct = nums[0];
	        int currMin = 1 ,currMax = 1; 
	        while(index < nums.length){
	            int temp = currMax;
	            currMax = Math.max(Math.max(nums[index] * currMax,nums[index] * currMin),nums[index]);
	            currMin = Math.min(Math.min(nums[index] * temp,nums[index] * currMin),nums[index]);
	            
	            if(maxProduct < currMax){
	                maxProduct = currMax;
	            }
	            index++;

	        }
	        return maxProduct;
	    }
	
	public static void main(String[] args) {
		int maxProduct = maxProduct(new int[] {-2,0,1});
		System.out.println(maxProduct);
	}
}
