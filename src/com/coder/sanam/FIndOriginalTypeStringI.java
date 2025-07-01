package com.coder.sanam;

public class FIndOriginalTypeStringI {

    public static void main(String[] args) {
        FIndOriginalTypeStringI fIndOriginalTypeStringI = new FIndOriginalTypeStringI();
        int i = fIndOriginalTypeStringI.possibleStringCount_Optimal("ere");
        System.out.println(i);
    }

    public int possibleStringCount(String word) {
        int[] freq = new int[26];
        int count = 0;
        char prevChar = word.charAt(0);
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            freq[ch-'a']++;
            if(ch != prevChar ){
                if(freq[prevChar -'a'] > 1){
                    count += freq[prevChar-'a'] -1;
                }
                freq[prevChar-'a'] = 0;
                prevChar = ch;
            }
            if(i==word.length()-1){
                if(freq[ch -'a'] > 1){
                    count += freq[ch-'a'] -1;
                    freq[ch-'a'] = 0;
                }
            }
        }

        return 1+ count;
    }


    public int possibleStringCount_Optimal(String word) {
        int i = 0;
        int n = word.length();
        int result = 0;
        while(i<n){
            char ch = word.charAt(i);
            int count = 0;
            while(i<n && ch == word.charAt(i) ){
                count++;
                i++;
            }
            if(count > 1){
                result += count-1;
            }
        }
        return result +1;
    }
}
