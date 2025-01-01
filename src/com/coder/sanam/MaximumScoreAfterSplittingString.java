package com.coder.sanam;

public class MaximumScoreAfterSplittingString {

    public static void main(String[] args) {
        MaximumScoreAfterSplittingString maximumScoreAfterSplittingString = new MaximumScoreAfterSplittingString();
        int i = maximumScoreAfterSplittingString.maxScore("011101");
        System.out.println(i);
    }

    public int maxScore(String s) {
        int n = s.length();
        int[] noOfZeroes = new int[n];
        int[] noOfOnes = new int[n];
        noOfZeroes[0] = s.charAt(0)=='0'?  1: 0;
        noOfOnes[n-1] = s.charAt(n-1)=='1'? 1:0;
        if(n==2) return noOfZeroes[0] + noOfOnes[n-1];
        for(int i=1;i<n;i++){
            if(s.charAt(i)=='0'){
                noOfZeroes[i] = noOfZeroes[i-1]+1;
            }else{
                noOfZeroes[i] = noOfZeroes[i-1];
            }
        }

        for(int j=n-2;j>=0;j--){
            if(s.charAt(j)=='1'){
                noOfOnes[j] = noOfOnes[j+1]+1;
            }else{
                noOfOnes[j] = noOfOnes[j+1];
            }
        }

        int res = Integer.MIN_VALUE;
        for(int k=1;k<n-1;k++){
            if(res<noOfZeroes[k]+ noOfOnes[k]){
                res = noOfZeroes[k]+ noOfOnes[k];
            }
        }
        return res;

    }
}
