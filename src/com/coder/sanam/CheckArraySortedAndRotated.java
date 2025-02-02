package com.coder.sanam;

public class CheckArraySortedAndRotated {

        public boolean check(int[] nums) {
            int n = nums.length;
            int count = 0;
            for (int i=0;i<n;i++){
                if(nums[i]>nums[(i+1)%n]){
                    count++;
                }
                if(count >1){
                    return false;
                }
            }
            return true;
        }

    public static void main(String[] args) {
        CheckArraySortedAndRotated checkArraySortedAndRotated = new CheckArraySortedAndRotated();
        boolean check = checkArraySortedAndRotated.check(new int[]{3,4,5,1,2});
        System.out.println(check);
    }
}
