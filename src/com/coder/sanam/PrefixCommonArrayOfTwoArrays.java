package com.coder.sanam;

import java.util.Set;

public class PrefixCommonArrayOfTwoArrays {

    public static void main(String[] args) {
        PrefixCommonArrayOfTwoArrays prefixCommonArrayOfTwoArrays = new PrefixCommonArrayOfTwoArrays();
        int[] A = {1,3,2,4};
        int[] B = {3,1,2,4};
        int[] res = prefixCommonArrayOfTwoArrays.findThePrefixCommonArray(A, B);
        for(int i: res){
            System.out.print(i+" ");
        }

    }

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        //0 based frequency Array
        int[] freq = new int[n];
        int[] res = new int[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(A[i] == B[i]){
                count++;
            }else{
                if(++freq[A[i]-1] == 2){
                    count++;
                }
                if(++freq[B[i]-1] == 2){
                    count++;
                }
            }

            res[i] = count;
        }
        return res;
    }
}
