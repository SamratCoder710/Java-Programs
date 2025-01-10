package com.coder.sanam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordsSubsets {

    public static void main(String[] args) {
        WordsSubsets wordsSubsets = new WordsSubsets();
        List<String> strings = wordsSubsets.wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"},
                new String[]{"e", "o"});
        strings.forEach(System.out::println);
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] tempArray = new int[26];
        int[] maxFreqArray = new int[26];

        for(String word: words2){
            Arrays.fill(tempArray,0);
            for(char ch : word.toCharArray()){
                tempArray[ch-'a']++;
            }
            for(int i=0;i<26;i++){
                maxFreqArray[i] = Math.max(maxFreqArray[i],tempArray[i]);
            }
        }
        List<String> result = new ArrayList<>();

        for(String word: words1){
            Arrays.fill(tempArray,0);
            for(char ch: word.toCharArray()){
                tempArray[ch-'a']++;
            }
            boolean isUniversal = true;
            for(int i=0;i<26;i++){
                if(maxFreqArray[i] > tempArray[i]){
                    isUniversal = false;
                    break;
                }
            }
            if(isUniversal){
                result.add(word);
            }
        }

        return result;
    }
}
