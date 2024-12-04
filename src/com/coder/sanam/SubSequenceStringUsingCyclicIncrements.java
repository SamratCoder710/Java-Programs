package com.coder.sanam;

public class SubSequenceStringUsingCyclicIncrements {

    public static void main(String[] args) {
        boolean b = canMakeSubsequence("abc", "ad");
        System.out.println(b);
    }

    public static boolean canMakeSubsequence(String str1, String str2) {
        int i = 0,j = 0;
        int m = str1.length();
        int n = str2.length();
        while(j<n && i<m){
            if(str2.charAt(j) == str1.charAt(i) || str2.charAt(j) == str1.charAt(i) + 1  ||
                    str2.charAt(j) == str1.charAt(i) - 25){
                j++;
            }
            i++;
        }
        return j==str2.length();
    }
}
