package com.coder.sanam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	
	public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            if(nums[i]>0){ return result;}
            int left = i+1,right=nums.length -1;
            while(left<right){
                int threesome = nums[i]+nums[left]+nums[right];
                if(threesome > 0){
                    right -= 1;
                }else if(threesome < 0){
                    left += 1;
                }else{
                    result.add(new ArrayList<>(Arrays.asList(nums[i],nums[left],nums[right])));
                    left += 1;
                    while(nums[left]==nums[left-1] && left < right) {
                    	left += 1;
                    }
                }
            }
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		List<List<Integer>> threeSum = threeSum(new int[] {-1,0,1,2,-1,-4});
		System.out.println(threeSum);
	}

}
