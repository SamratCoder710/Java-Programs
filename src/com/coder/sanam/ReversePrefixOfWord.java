package com.coder.sanam;

import java.util.Arrays;

public class ReversePrefixOfWord {
    public static String reversePrefix(String word, char ch) {
       int index = word.indexOf(ch);
       if(index != -1){
           return new StringBuilder(word.substring(0,index)).reverse().toString();
       }
       return word;
    }


    public static void main(String[] args) {
        String s = reversePrefix("xyxzxe", 'z');
        System.out.println(s);
    }


}
