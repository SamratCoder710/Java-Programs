package com.coder.sanam;

public class GreatestEnglishInUpperAndLower {

    public static void main(String[] args) {
        GreatestEnglishInUpperAndLower greatestEnglishInUpperAndLower = new GreatestEnglishInUpperAndLower();
        String result = greatestEnglishInUpperAndLower.greatestLetter("eE");
        System.out.println(result);
    }

    public String greatestLetter(String s) {
        int [] freq = new int[58];
        StringBuilder result  = new StringBuilder();
        for(char ch: s.toCharArray()){
            freq[ch-'A']++;
        }

        for(int i=25;i>=0;i--){
            if(freq[i] > 0 && freq[i+32] > 0){
                result.append((char) (i + 'A'));
                return result.toString();
            }
        }
        return result.toString();
    }
}
