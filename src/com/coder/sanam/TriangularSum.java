package com.coder.sanam;

public class TriangularSum {

    public static void main(String[] args) {
        TriangularSum triangularSum = new TriangularSum();
        int i = triangularSum.triangularSum(new int[]{1, 2, 3, 4, 5});
        System.out.println(i);
    }
    public int triangularSum(int[] nums) {
        int n = nums.length;
        while(n > 1){
            for(int i=0;i<n-1;i++){
                nums[i] = (nums[i] + nums[i+1]) % 10;
            }
            n--;
        }
        return nums[0];
    }
}
