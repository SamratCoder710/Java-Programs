package com.coder.sanam;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class HIndex {
    public static void main(String[] args) {
        int i = hIndex(new int[]{1,3,1});
        System.out.println(i);
    }

    public static int hIndex(int[] citations) {

        Arrays.sort(citations);
        int n = citations.length;
        int maxi =0;
        for(int i=0;i<n;i++){
            System.out.println(n-i);
            if(citations[i]>= n-i){
                maxi = Math.max(maxi,n-i);
            }
        }
        return maxi;

    }
}
