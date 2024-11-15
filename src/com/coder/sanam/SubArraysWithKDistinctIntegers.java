package com.coder.sanam;

import java.util.*;

public class SubArraysWithKDistinctIntegers {
	
	public static int slidingWindow(int[] nums, int k) {
        int i = 0;
        int n = nums.length;

        int ans = 0;
        Map<Integer,Integer> freq = new HashMap<>();
        for(int j=0;j<n;j++){
            freq.put(nums[j],freq.getOrDefault(nums[j],0)+1);
            while(freq.size() >k){
                freq.put(nums[i],freq.get(nums[i])-1);
                if(freq.get(nums[i]) == 0){
                	freq.remove(nums[i]);
                   
                }
                i++;
            }
            ans += j-i+1;
            
        }
        return ans;
    }

	public static int subarraysWithKDistinct(int[] nums, int k) {
		return slidingWindow(nums, k) - slidingWindow(nums, k-1);
	}
	
	public static void main(String[] args) {
		int subarraysWithKDistinct = subarraysWithKDistinct(new int[] {1,2,1,2,3}, 2);
		System.out.println(subarraysWithKDistinct);
	}
}
