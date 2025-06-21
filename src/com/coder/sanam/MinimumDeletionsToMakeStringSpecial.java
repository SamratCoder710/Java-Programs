package com.coder.sanam;

import static java.lang.Math.abs;

public class MinimumDeletionsToMakeStringSpecial {

    public static void main(String[] args) {
        MinimumDeletionsToMakeStringSpecial minimumDeletionsToMakeStringSpecial = new MinimumDeletionsToMakeStringSpecial();
        int i = minimumDeletionsToMakeStringSpecial.minimumDeletions("aabcaba", 0);
        System.out.println(i);

    }

    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for(char ch: word.toCharArray()){
            freq[ch-'a']++;
        }

        int result = word.length();
        for(int i=0;i<26;i++){
            int del = 0;
            for(int j=0;j<26;j++){
                if(i == j) continue;

                if(freq[j] < freq[i]){
                    del += freq[j];
                }else if(abs(freq[j] - freq[i]) > k){
                    del += abs(freq[j] - freq[i] - k);
                }
            }
            result = Math.min(result,del);
        }

        return result;
    }
}
