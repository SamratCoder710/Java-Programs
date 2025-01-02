package com.coder.sanam;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountVowelStringInRanges {

    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        // Assuming -1 indexed noOfVowelString
        // 0 vowel at index -1
        int[] noOfVowelString = new int[n+1];
        noOfVowelString[0] = 0;
        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        for(int i=0;i<n;i++){
            String checkString = words[i];
            int len = checkString.length();
            if(set.contains(checkString.charAt(0)) && set.contains(checkString.charAt(len-1))){
                noOfVowelString[i+1] = noOfVowelString[i]+1;
            }else{
                noOfVowelString[i+1] = noOfVowelString[i];
            }
        }
        int[] res = new int[queries.length];
        int idx = 0;
        for(int[] arr: queries){
            int left = arr[0];
            int right = arr[1];
            res[idx] =  noOfVowelString[right+1] - noOfVowelString[left];
            idx++;
        }
        return res;
    }

    public static void main(String[] args) {
        CountVowelStringInRanges countVowelStringInRanges = new CountVowelStringInRanges();
        int[] vowelStrings = countVowelStringInRanges.vowelStrings(
                new String[]{"aba", "bcb", "ece", "aa", "e"},
                new int[][]{{0, 2}, {1, 4}, {1, 1}}
        );
        System.out.println(Arrays.toString(vowelStrings));
    }
}
