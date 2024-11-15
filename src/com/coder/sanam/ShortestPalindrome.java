package com.coder.sanam;

public class ShortestPalindrome {

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("abcd"));
    }

    public static String shortestPalindrome(String s) {
        for(int j=s.length()-1;j>=0;j--){
            if(isPalindrome(0,j,s.toCharArray())){
                return new StringBuilder(s.substring(j+1)).reverse()+s;
            }
        }
        return "";
    }

    private static boolean isPalindrome(int l,int r,char[] k){
        while(l<=r){
            if(k[l]!= k[r]) return false;
            l = l+1;
            r = r-1;
        }
        return true;
    }
}
