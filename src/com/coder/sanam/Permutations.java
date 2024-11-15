package com.coder.sanam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> ds = new ArrayList<>();
		boolean freq[] = new boolean[nums.length];
		recurPermute(ans,nums,ds,freq);
		return ans;
		
    }
	
	

	private static void recurPermute(List<List<Integer>> ans, int[] nums, List<Integer> ds, boolean[] freq) {
		if(ds.size() == nums.length) {
			ans.add(new ArrayList<>(ds));
			return;
		}
		for(int i=0;i<nums.length;i++) {
			if(!freq[i]) {
				freq[i] = true;
				ds.add(nums[i]);
				recurPermute(ans,nums,ds,freq);
				ds.remove(ds.size() - 1);
				freq[i]= false;
			}
		}
	}



	public static void main(String[] args) {
		List<List<Integer>> permute = permute(new int[] {1,2,3});
		System.out.println(permute);
	}
}
