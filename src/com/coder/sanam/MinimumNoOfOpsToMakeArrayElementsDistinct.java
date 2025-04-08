package com.coder.sanam;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumNoOfOpsToMakeArrayElementsDistinct {

    public static void main(String[] args) {
        MinimumNoOfOpsToMakeArrayElementsDistinct result  = new MinimumNoOfOpsToMakeArrayElementsDistinct();
        int i = result.minimumOperations(new int[]{6,7,8,9});
        System.out.println(i);
    }

    public int minimumOperationsOptimal(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int i=n-1;i>=0;i--){
            boolean eleAdded = set.add(nums[i]);
            if(!eleAdded){
                return ((i+1)%3 == 0 ? (i+1)/3 : ((i+1)/3 + 1));
            }
        }
        return 0;

    }

    public int minimumOperations(int[] nums) {
        Set<Integer> s = new HashSet<>();
        Map<Integer, Integer> mp = new HashMap<>();
        for(int num: nums){
            boolean eleAdded = s.add(num);
            if(!eleAdded){
                mp.put(num,mp.getOrDefault(num,0) +1);
            }
        }

        int res = 0;
        int i = 0;
        while(!mp.isEmpty()){
            for(int k=0;k<3;k++){
                if(i+k< nums.length && mp.getOrDefault(nums[i+k],0) != 0){
                    mp.put(nums[i+k],mp.get(nums[i+k]) -1);
                    if(mp.get(nums[i+k]) == 0){
                        mp.remove(nums[i+k]);
                    }
                }
            }
            i+=3;
            res++;
        }
        return res;

    }
}
