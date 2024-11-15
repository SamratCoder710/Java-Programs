package com.coder.sanam;

public class RemoveElement {

    public static void main(String[] args) {
        int res = removeDuplicatesII(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        System.out.println(res);
    }

    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int last = n-1;
        int valCount = 0;
        for(int i=0;i<n;i++){
            if(nums[i]==val){

                while(nums[last] == val){
                    last--;
                }

                int temp = nums[i];
                nums[i] = nums[last];
                nums[last] = temp;
                last--;
                valCount++;
            }
        }
        return n-valCount;
    }


    public static int removeDuplicates(int[] nums) {
        int i=0;
        int index = 0;
        while(i<nums.length){
            while(i+1<nums.length && nums[i]==nums[i+1]){
                i++;
            }
            nums[index] = nums[i];
            index++;
            i++;
        }
        return index;
    }

    public static int removeDuplicatesII(int[] nums) {
        int n = nums.length;
        int i=0;
        int index = 0;
        while(i<n){

            while(i+1<n && nums[i]==nums[i+1]){
                i++;
            }
            if( i-index>0){
                nums[index] = nums[i];
                nums[++index] = nums[i];
            }
            index++;
            i++;
        }
        return index;
    }



}
