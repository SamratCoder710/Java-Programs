package com.coder.sanam;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	
	public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int x:nums) {
        	set.add(x);
        }
        int largest = Integer.MIN_VALUE;
        for(int i=0;i<set.size();i++) {
        	if(!set.contains(nums[i]-1)) {
        		int k = 0;
        		while(set.contains(nums[i]+k)) {
        			k++;
        		}
        		largest = Math.max(largest, k);
        	}
        }
        return largest;
        
    }

	public static void main(String[] args) {
		System.out.println(longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1}));
	}
}
