package com.coder.sanam;

import java.util.Arrays;

public class NthValueAfterKSeconds {

    public static void main(String[] args) {
        NthValueAfterKSeconds nthValueAfterKSeconds = new NthValueAfterKSeconds();
        int result = nthValueAfterKSeconds.valueAfterKSeconds(3, 2);
        System.out.println(result);
    }

    public int valueAfterKSeconds(int n, int k) {
        int[] prefixSum = new int[n];
        Arrays.fill(prefixSum, 1);

        while(k-- >0){
            for(int i=1;i<n;i++){
                prefixSum[i] = (prefixSum[i] + prefixSum[i-1]) % 1_000_000_007;
            }
        }

        return prefixSum[n-1];
    }
}
