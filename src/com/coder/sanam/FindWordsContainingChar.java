package com.coder.sanam;

import java.util.ArrayList;
import java.util.List;

public class FindWordsContainingChar {

    static void main() {

    }

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<>();
        int n = words.length;
        for(int i=0;i<n;i++){
            if(words[i].contains(x+"")){
                list.add(i);
            }
        }
        return list;
    }


    public List<Integer> findWordsContainingAlternative(String[] words, char x) {
        List<Integer> list = new ArrayList<>();
        int n = words.length;
        for(int i=0;i<n;i++){
            for(char ch : words[i].toCharArray()) {
                if(ch == x){
                    list.add(i);
                }
            }
        }
        return list;
    }

    public List<Integer> findWordsContainingAlternativeII(String[] words, char x) {
        List<Integer> list = new ArrayList<>();
        int n = words.length;
        for(int i=0;i<n;i++){
            if(words[i].indexOf(x) != -1){
                list.add(i);
            }
        }
        return list;
    }
}
