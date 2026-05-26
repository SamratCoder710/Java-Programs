package com.coder.sanam;

public class CountNumberOfSpecialCharactersI {
    public static void main(String[] args) {
        CountNumberOfSpecialCharactersI countNumberOfSpecialCharactersI = new CountNumberOfSpecialCharactersI();
        int result = countNumberOfSpecialCharactersI.numberOfSpecialChars("aAbc");
        System.out.println(result);
    }

    public int numberOfSpecialChars(String word) {
        int[] freq = new int[58];
        int count = 0;
        // A 65
        // a 97
        for(char ch : word.toCharArray()){
            int val = ch - 'A';
            freq[val]++;
        }

        for(int i=0;i<26;i++){
            if(freq[i] > 0 && freq[i+32] > 0){
                count++;
            }
        }

        return count;
    }
}
