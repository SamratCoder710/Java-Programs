package com.coder.sanam;

import java.util.Arrays;

public class LargestNumberFromArray {

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{3,30,34,5,9}));
    }

    public static String largestNumber(int[] nums) {
        int n = nums.length;
        String[] s = new String[n];
        for(int i=0;i<n;i++){
            s[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s,(a,b)-> (b+a).compareTo(a+b));
        StringBuilder sb = new StringBuilder();
        for(String k:s){
            sb.append(k);
        }
        String result = sb.toString();
        return result.startsWith("0")?"0":result;
    }
}
