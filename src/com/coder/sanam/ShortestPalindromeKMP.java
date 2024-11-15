package com.coder.sanam;

public class ShortestPalindromeKMP {

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("aacecaaa"));
    }

        public static String shortestPalindrome(String s) {
            int count = kmp(new StringBuilder(s).reverse().toString(), s);
            return new StringBuilder(s.substring(count)).reverse().toString() + s;
        }

        private static int kmp(String txt, String patt) {
            String newString = patt + '#' + txt;
            int[] pi = new int[newString.length()];
            int i=1; int k=0;
            while (i<newString.length()){
                if(newString.charAt(i) == newString.charAt(k)){
                    k++;
                    pi[i] = k;
                    i++;
                }else{
                    if(k>0){
                        k = pi[k-1];
                    }else{
                        pi[k] = 0;
                        i++;
                    }
                }
            }
            return pi[pi.length - 1];
        }

}
