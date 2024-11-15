package com.coder.sanam;

import java.util.Arrays;

public class MinimizedMaximum {

    public static void main(String[] args) {
        System.out.println(minimizedMaximum(7, new int[]{15,10,10}));
    }

    public static int minimizedMaximum(int n, int[] quantities) {
        int low = 1;
        int high = Arrays.stream(quantities).max().getAsInt();
        int ans = -1;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(solve(n,quantities,mid)){
                ans = mid;
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return ans;

    }

    private static boolean solve(int n, int[] quantities, int value) {
        if(value == 0)  return false;
        int count = 0;
        for (int quantity : quantities) {
            count += (quantity - 1) / value + 1;
            if (count > n) return false;
        }
        return true;
    }
}
