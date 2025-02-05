package com.coder.sanam;

import java.util.Arrays;

public class CheckIfStringSwapCanMakeStringEqual {

    public static void main(String[] args) {
        CheckIfStringSwapCanMakeStringEqual checkIfStringSwapCanMakeStringEqual = new CheckIfStringSwapCanMakeStringEqual();
        boolean b = checkIfStringSwapCanMakeStringEqual.areAlmostEqual("bank", "kanb");
        System.out.println(b);
    }

    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        int count = 0;
        int[] freq = new int[26];
        for(int i=0;i<n;i++){
            if(s1.charAt(i) != s2.charAt(i)){
                count++;
                freq[s1.charAt(i) - 'a']++;
            }
        }
        boolean b = Arrays.stream(freq).anyMatch(i -> i != 2);
        return (count == 2 || count == 0) && !b;

    }

    public boolean areAlmostEqualOptimized(String s1, String s2) {
        int len = s1.length();
        int count = 0;
        int m=-1, n=-1;
        for(int i=0;i<len;i++){
            if(s1.charAt(i) != s2.charAt(i)){
                count++;
                if(m==-1) m=i;
                else if(n==-1) n=i;
            }
        }
        if(count == 0) return true;
        else if(count == 2 && s1.charAt(m) == s2.charAt(n) && s1.charAt(n) == s2.charAt(m)){
            return true;
        }
        return false;

    }
}
