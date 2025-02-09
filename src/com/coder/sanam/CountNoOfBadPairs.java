package com.coder.sanam;

import java.util.HashMap;
import java.util.Map;

public class CountNoOfBadPairs {

    public static void main(String[] args) {
        CountNoOfBadPairs countNoOfBadPairs = new CountNoOfBadPairs();
        long l = countNoOfBadPairs.countBadPairs(new int[]{4,1,3,3});
        System.out.println(l);
    }

    public long countBadPairs(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            nums[i] = nums[i]-i;
        }
        long result =0 ;
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){

            int totalPairs = i;
            int goodPairs =  freqMap.getOrDefault(nums[i],0);
            result += totalPairs - goodPairs;

            freqMap.put(nums[i],freqMap.getOrDefault(nums[i],0)+1);

        }
        return result;
    }
}
