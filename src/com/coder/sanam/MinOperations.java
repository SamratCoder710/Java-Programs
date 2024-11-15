package com.coder.sanam;

import java.util.HashMap;
import java.util.Map;

public class MinOperations {
	 public static int minOperations(int[] nums) {
	        Map<Integer,Integer> countMap = new HashMap<>();
	        for(int x:nums) {
	        	countMap.put(x, countMap.getOrDefault(x, 0) + 1);
	        }
	        if(countMap.values().contains(1)) {
	        	return -1;
	        }
	        int result = 0;
	        for(int k: countMap.values()) {
	        	result += calculateMinOps(k);
	        }
	        return result;
	    }
	 
	 private static int calculateMinOps(int k) {
		 if(k == 3 || k==2) return 1;
		 if(k%3==0) {
			 return k/3;
		 }else {
			 return (k/3) +1;
		 }
	}

	public static void main(String[] args) {
		int minOperations = minOperations(new int[] {2,3,3,2,2,4,2,3,4});
		System.out.println(minOperations);
	}
}
