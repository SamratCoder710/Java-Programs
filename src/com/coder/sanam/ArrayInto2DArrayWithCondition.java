package com.coder.sanam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ArrayInto2DArrayWithCondition {
	public static List<List<Integer>> findMatrix(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if(nums.length == 0) return result;
		Map<Integer,Integer> countMap = new HashMap<>();
		for(int i:nums) {
			int row = countMap.getOrDefault(i, 0);
			if(result.size() == row) {
				result.add(new ArrayList<Integer>());
			}
			result.get(row).add(i);
			countMap.put(i,countMap.getOrDefault(i, 0)  + 1);
			
		}
		return result;
		
    }
	
	public static void main(String[] args) {
		List<List<Integer>> findMatrix = findMatrix(new int[] {1,3,4,1,2,3,1});
		System.out.println(findMatrix);
	}
}
