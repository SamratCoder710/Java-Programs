package com.coder.sanam;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubArrays {

    public static void main(String[] args) {
        long l = continuousSubarraysOptimized(new int[]{5, 4, 2, 4});
        System.out.println(l);
    }


    //TLE
    public static long continuousSubarrays(int[] nums) {
        int n = nums.length;
        long count = 0;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int j = i;j<n;j++){
                min = Math.min(nums[j],min);
                max = Math.max(nums[j],max);
                if(max - min<=2){
                    count++;
                }
            }
        }
        return count;
    }


    public static long continuousSubarraysOptimized(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> mp = new HashMap<>();
        long count = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
            while((i-j+1) > getCountOperation(nums[i],mp)){
                mp.put(nums[j], mp.get(nums[j]) - 1);
                j++;
            }
            count += i-j+1;
        }
        return count;
    }

    private static int getCountOperation(int num, Map<Integer, Integer> mp) {
        return mp.getOrDefault(num ,0 )+
                mp.getOrDefault(num -1,0 )+
                mp.getOrDefault(num -2,0 )+
                mp.getOrDefault(num +1,0 )+
                mp.getOrDefault(num +2,0 );

    }
}
