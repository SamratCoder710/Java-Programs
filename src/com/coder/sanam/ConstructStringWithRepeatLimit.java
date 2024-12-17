package com.coder.sanam;

public class ConstructStringWithRepeatLimit {

    public static void main(String[] args) {
        String s = repeatLimitedString("cczazcc", 3);
        System.out.println(s);
    }

    public static String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for(char ch: s.toCharArray()){
            freq[ch-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int i = 25;
        while(i>=0){
            if(freq[i] == 0){
                i--;
                continue;
            }
            int newFreq = Math.min(freq[i], repeatLimit);
            char ch = (char) (i + 97);
            freq[i] -= newFreq;
            sb.append(String.valueOf(ch).repeat(newFreq));

            if(freq[i] > 0){
                //find next non-zero freq char
                int j= i-1;
                while(j>=0 && freq[j]==0){
                    j--;
                }
                if(j<0){
                    break;
                }
                sb.append((char)(j+97));
                freq[j]--;
            }

        }

        return sb.toString();
    }
}
