package com.coder.sanam;

import java.util.HashMap;
import java.util.Map;

class TwoSumTarget {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> indexMap = new HashMap<>();
        int n = nums.length;
        //Build index map table

        for(int i=0;i<n;i++){
            int complement = target - nums[i];
            if(indexMap.containsKey(complement) && indexMap.get(complement) !=i){
                return new int[]{i,indexMap.get(complement)};
            }
            indexMap.put(nums[i],i);
        }

        return new int[]{};
        
    }
}
