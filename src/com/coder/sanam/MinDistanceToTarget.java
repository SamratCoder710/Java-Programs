package com.coder.sanam;

public class MinDistanceToTarget {

    public static void main(String[] args) {
        MinDistanceToTarget minDistanceToTarget = new MinDistanceToTarget();
        int minDistance = minDistanceToTarget.getMinDistance(new int[]{1,2,3,4,5}, 5, 3);
        System.out.println(minDistance);

    }


    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;
        int minDist = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i] == target){
                minDist = Math.min(minDist, Math.abs(i-start));
            }
        }
        return minDist;
    }
}
