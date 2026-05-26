package com.coder.sanam;

import java.util.Arrays;

public class CountNumberOfSpecialCharactersII {

    public static void main(String[] args) {
        CountNumberOfSpecialCharactersII countNumberOfSpecialCharactersII = new CountNumberOfSpecialCharactersII();
        int result = countNumberOfSpecialCharactersII.numberOfSpecialChars("AbBCab");
        System.out.println(result);
    }

    public int numberOfSpecialChars(String word) {

        int n = word.length();
        int [] lastOccSmall = new int[26];
        int [] firstOccCap = new int[26];

        Arrays.fill(lastOccSmall, -1);
        Arrays.fill(firstOccCap, -1);
        for(int i=0;i<n;i++){
            int currChar = word.charAt(i) -'A';
            if(currChar < 26){
                //upper
                if(firstOccCap[currChar] == -1){
                    firstOccCap[currChar] = i;
                }
            }else{
                //lower
                lastOccSmall[currChar - 32] = i;
            }
        }

        int count = 0;
        for(int i=0;i<26;i++){
            if(lastOccSmall[i] != -1 && firstOccCap[i] != -1 &&
                    lastOccSmall[i] < firstOccCap[i]){
                count++;
            }
        }
        return count;
    }
}
