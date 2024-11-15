package com.coder.sanam;
import java.util.ArrayList;
import java.util.List;

public class SubSetsBackTracking {
	public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        backtracking(resultList,new ArrayList<>(),nums,0);
        return resultList;
    }

	private static void backtracking(List<List<Integer>> resultList, List<Integer> tempList, int[] nums, int start) {
		resultList.add(new ArrayList<>(tempList));
		for(int i=start;i<nums.length;i++) {
			tempList.add(nums[i]);
			
			backtracking(resultList, tempList, nums, i + 1);
			
			tempList.remove(tempList.size() - 1);
			
		}
		
		
	}
	
	public static void main(String[] args) {
		List<List<Integer>> subsets = subsets(new int[] {1,2,3});
		System.out.println(subsets);
	}

}
