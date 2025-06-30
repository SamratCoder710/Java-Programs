package com.coder.sanam;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {

    public static void main(String[] args) {
        LongestHarmoniousSubsequence longestHarmoniousSubsequence = new LongestHarmoniousSubsequence();
        int i = longestHarmoniousSubsequence.findLHS(new int[]{1, 3, 2, 2, 5, 4, 3, 2});
        System.out.println(i);
    }

    public int findLHS(int[] nums) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int num: nums){
            freq.put(num,freq.getOrDefault(num,0)+ 1);
        }
        int result = Integer.MIN_VALUE;

        for(int num: nums){
            int min = num;
            int max = num+1;

            if(freq.getOrDefault(max,0) != 0){
                result = Math.max(result,freq.get(min) + freq.get(max));
            }

        }
        return result;

    }
}
