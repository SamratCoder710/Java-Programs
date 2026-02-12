package com.coder.sanam;

public class LongestBalancedSubStringI {

    public static void main(String[] args) {
        LongestBalancedSubStringI longestBalancedSubStringI = new LongestBalancedSubStringI();
        int i = longestBalancedSubStringI.longestBalanced("abbac");
        System.out.println(i);
    }

    private boolean checkSameFreq(int [] freq,int charIdx){
        for(int i=0;i<26;i++){
            if(freq[i] == 0) continue;
            if(freq[i] != freq[charIdx]){
                return false;
            }
        }
        return true;
    }

    public int longestBalanced(String s) {
        int n = s.length();
        int result =0;
        for(int i=0;i<n;i++){
            int[] freq = new int[26];
            for(int j=i;j<n;j++){
                int charIdx = s.charAt(j) - 'a';
                freq[charIdx]++;
                if(checkSameFreq(freq,charIdx)){
                    result = Math.max(result,j-i+1);
                }
            }
        }
        return result;
    }
}
