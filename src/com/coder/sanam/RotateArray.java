package com.coder.sanam;

public class RotateArray {
    public static void main(String[] args) {
        rotate(new int[]{1},1);
    }

    public static void rotate(int[] nums, int k) {
        if(k==0) return;
        k = k%nums.length;
        int l=0;int r=nums.length-1;
        int mid = l +(r-l)/2;
        while(l< mid){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }

        l=0;
        r=k-1;
        mid  = l +(r-l)/2;
        while(l<mid){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }

        l=k;
        r=nums.length-1;
        mid = l+(r-l)/2;
        while(l<mid){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}
