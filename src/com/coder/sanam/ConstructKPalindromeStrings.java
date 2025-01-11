package com.coder.sanam;

public class ConstructKPalindromeStrings {

    public static void main(String[] args) {
        ConstructKPalindromeStrings constructKPalindromeStrings = new ConstructKPalindromeStrings();
        boolean b = constructKPalindromeStrings.canConstruct("annabelle", 2);
        System.out.println(b);
    }

    public boolean canConstruct(String s, int k) {
        int n = s.length();
        if(n<k) return false;

        if(n==k) return true;

        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        int oddFreqCount = 0;
        for(int i: freq){
            if(i % 2!=0){
                oddFreqCount++;
            }
        }
        return oddFreqCount<=k;
    }
}
