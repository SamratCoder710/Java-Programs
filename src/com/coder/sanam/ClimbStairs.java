package com.coder.sanam;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {
	
	public static int climbStairs(int n) {
		Map<Integer,Integer> climbMap = new HashMap<>();
        return climb(n,new int[]{1,2},climbMap);
    }

    private static int climb(int target,int[] steps,Map<Integer,Integer> climbMap){
    	if(climbMap.get(target) != null) return climbMap.get(target);
        if(target == 0) return 1;
        int result = 0;
        if(target < 0 ) return result;
        for(int i=0;i<steps.length;i++){
        	result += climb(target-steps[i],steps,climbMap);
            climbMap.put(target, result);
        }
        return result;
    }
    
    public static void main(String[] args) {
		int climbStairs = climbStairs(44);
		System.out.println(climbStairs);
	}

}
