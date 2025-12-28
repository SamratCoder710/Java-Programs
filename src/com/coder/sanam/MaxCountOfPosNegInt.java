package com.coder.sanam;

public class MaxCountOfPosNegInt {

    public static void main(String[] args) {
        MaxCountOfPosNegInt obj = new MaxCountOfPosNegInt();
        int[] nums = {-2,-1,-1,1,2,3};
        // result should be 3
        System.out.println(obj.maximumCount(nums));
    }


    public int maximumCount(int[] nums) {
        int neg = 0;
        int pos = 0;
        int n = nums.length;
        boolean signChanged = false;
        for(int idx=0;idx<n;idx++){
            if(nums[idx] >=0){
                neg = idx;
                while(idx<n && nums[idx] == 0){
                    idx++;
                }
                pos = n-idx;
                signChanged = true;
                break;
            }
        }

        if(!signChanged){return n; }
        return Math.max(pos,neg);
    }
}
