package com.coder.sanam;

import java.util.List;

public class MinBitwiseArrayII {

    public static void main(String[] args) {
        MinBitwiseArrayII minBitwiseArrayII = new MinBitwiseArrayII();
        int[] result = minBitwiseArrayII.minBitwiseArray(List.of(2,3,5,7));
        for(int r : result) {
            System.out.print(r + " ");
        }
    }

    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] result = new int[n];
        for(int i=0; i<n;i++){
            if(nums.get(i) == 2){
                result[i] = -1;
                continue;
            }
            boolean found = false;
            for(int j=0;j<32;j++){
                if((nums.get(i) & (1<<j)) > 0){
                    continue;
                }
                int prev = j - 1;
                int x = nums.get(i) ^ (1<<prev);
                result[i] = x;
                found = true;
                break;
            }
            if(!found){
                result[i] = -1;
            }
        }
        return result;
    }
}
