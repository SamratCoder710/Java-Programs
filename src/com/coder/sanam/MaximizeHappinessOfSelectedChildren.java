package com.coder.sanam;

import java.util.Arrays;

public class MaximizeHappinessOfSelectedChildren {

    public static void main(String[] args) {
        MaximizeHappinessOfSelectedChildren obj = new MaximizeHappinessOfSelectedChildren();
        int[] happiness = {1,1,1,1};
        int k = 2;
        System.out.println(obj.maximumHappinessSum(happiness, k));

    }

    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;
        long result = 0;
        long sub = 0;
        for(int i=n-1;i>= n-k;i--){
            result += Math.max(happiness[i] - sub,0);
            sub++;
        }
        return result;
    }
}
