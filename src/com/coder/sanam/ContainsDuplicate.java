package com.coder.sanam;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

	public static boolean containsDuplicate(int[] nums) {
		Set<Integer> result = new HashSet<>();
        for(int i=0;i<nums.length;i++) {
        	int prev_size = result.size();
        	result.add(nums[i]);
        	int new_size = result.size();
        	if(prev_size == new_size) {
        		return true;
        	}
        }
        return false;
    }
	
	public static boolean containsDuplicateWithSorting(int[] nums) {
		Arrays.sort(nums);
		
		for(int i=0;i<nums.length -1;i++) {
			if(nums[i] == nums[i+1]) {
				return true;
			}
		}
		return false;
    }
	
	public static void main(String[] args) {
		boolean containsDuplicate = containsDuplicate(new int[]{3,4,9,14});
		System.out.println(containsDuplicate);
	}
}
