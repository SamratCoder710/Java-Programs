package com.coder.sanam;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BitwiseXORofAllPairs {
    public static void main(String[] args) {
        BitwiseXORofAllPairs bitwiseXORofAllPairs = new BitwiseXORofAllPairs();
        int[] nums1 = {1,2};
        int i = bitwiseXORofAllPairs.xorAllNums(nums1, new int[]{3,4});
        System.out.println(i);
    }


    public int xorAllNums(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        Map<Integer,Integer> freq = new HashMap<>();
        for(int num : nums1){
            freq.put(num,freq.getOrDefault(num,0) + n);
        }
        for(int num : nums2){
            freq.put(num,freq.getOrDefault(num,0) + m);
        }

        int res = 0;
        for(int num : freq.keySet()){
            if(freq.get(num) % 2 != 0){
                res ^= num;
            }
        }
        return res;
    }
}
