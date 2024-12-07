package com.coder.sanam;

public class MinimumLimitOfBalls {

    public static void main(String[] args) {
        int i = minimumSize(new int[]{2,4,8,2}, 4);
        System.out.println(i);
    }

    public static int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = Integer.MIN_VALUE;
        for(int i: nums){
            right = Math.max(right,i);
        }
        int result = right;
        while(left<= right){
            int mid = left + (right-left)/2;
            if(isPossible(mid,maxOperations,nums)){
                result = mid;
                right = mid -1;
            }else{
                left = mid +1;
            }
        }
        return result;
    }

    private static boolean isPossible(int mid, int maxOperations, int[] nums) {
        int ops = 0;
        for(int num: nums){
            ops += num/mid;
            if(num%mid == 0){
                ops -= 1;
            }
        }
        return ops<=maxOperations;
    }
}
