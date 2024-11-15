package com.coder.sanam;

public class EquilibriumOfArray {
    public static void main(String[] args) {
        int equilibrium = equilibrium(new int[]{-7,1,5,2,-4,3,0});
        System.out.println(equilibrium);
    }

    public static int equilibrium(int[] arr){
        int n = arr.length;
        int prefixSum = 0; int suffixSum = 0;
        int[] prefixArr = new int[n];
        int[] suffixArr = new int[n];
        for(int i=0;i<n;i++){
            prefixSum += arr[i];
            suffixSum += arr[n-i-1];

            prefixArr[i] = prefixSum;
            suffixArr[n-1-i] = suffixSum;
        }

        for(int i=0;i<n;i++){
            if(prefixArr[i] == suffixArr[i]) return i;
        }
        return -1;
    }
}
