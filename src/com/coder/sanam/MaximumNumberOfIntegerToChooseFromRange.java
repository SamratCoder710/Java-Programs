package com.coder.sanam;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MaximumNumberOfIntegerToChooseFromRange {

    public static void main(String[] args) {
        int i = maxCount(new int[]{1, 6, 5}, 5, 6);
        System.out.println(i);
    }

    public static int maxCount(int[] banned, int n, int maxSum) {
        int[] arr=new int[10001];
        for (int j : banned) {
            arr[j] = 1;
        }

        int count = 0;
        for(int i=1;i<=n;i++){
            if(arr[i]==0 && maxSum-i>=0){
                count++;
                maxSum -= i;
            }
        }
        return count;
    }
}
