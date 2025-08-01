package com.coder.sanam;

public class LongestSubarrayWithMaxBitwiseAND {


    public static void main(String[] args) {
        LongestSubarrayWithMaxBitwiseAND longestSubarrayWithMaxBitwiseAND = new LongestSubarrayWithMaxBitwiseAND();
        int i = longestSubarrayWithMaxBitwiseAND.longestSubarray(new int[]{1, 2, 3, 3, 2, 2});
        System.out.println(i);
    }

    public int longestSubarray(int[] nums) {
        int max = 0;
        int length = 0;
        int res = 0;
        for(int num : nums){
            if(num > max){
                max = num;
                res = 0;
                length = 0;
            }

            if(num == max){
                length++;
            }else{
                length = 0;
            }
            res = Math.max(res, length);

        }
        return res;

    }
}
