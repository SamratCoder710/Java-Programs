package com.coder.sanam;

public class MaxDiffByIncEle {

    public static void main(String[] args) {
        MaxDiffByIncEle ele = new MaxDiffByIncEle();
        int i = ele.maximumDifference(new int[]{7, 1, 5, 4});
        System.out.println(i);
    }


        public int maximumDifference(int[] nums) {
            int min = nums[0];
            int max = -1;
            for(int i=1;i<nums.length;i++){
                if(nums[i] > min){
                    max = Math.max(max,nums[i] - min);
                }
                if(nums[i]<min){
                    min = nums[i];
                }

            }
            return max;
        }
}
