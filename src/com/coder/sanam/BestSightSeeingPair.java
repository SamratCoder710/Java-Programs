package com.coder.sanam;

public class BestSightSeeingPair {

    public static void main(String[] args) {
        int i = maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6});
        System.out.println(i);
    }

    public static int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int m = values[0];
        int res = Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            if(values[i]-i+m > res){
                res = values[i] - i+m;
            }
            if(values[i]+ i > m){
                m = values[i] + i;
            }
        }
        return res;
    }
}
