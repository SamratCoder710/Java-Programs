package com.coder.sanam;

import java.util.HashSet;
import java.util.Set;

public class LongestBalancedSubArrayI {

    public static void main(String[] args) {
        LongestBalancedSubArrayI longestBalancedSubArrayI = new LongestBalancedSubArrayI();
        int i = longestBalancedSubArrayI.longestBalanced(new int[]{2,5,4,3});
        System.out.println(i);
    }

    private int longestBalanced(int[] nums) {
        int result = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            Set<Integer> even = new HashSet<>();
            Set<Integer> odd = new HashSet<>();
            for(int j=i;j<n;j++){
                if(nums[j] %2 == 0){
                    even.add(nums[j]);
                }else{
                    odd.add(nums[j]);
                }
                if(even.size() == odd.size()){
                    result = Math.max(result, j-i+1);
                }
            }
        }
        return result;
    }
}
