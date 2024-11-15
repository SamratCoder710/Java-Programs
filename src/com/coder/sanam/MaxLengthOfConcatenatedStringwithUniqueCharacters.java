package com.coder.sanam;

import java.util.*;

public class MaxLengthOfConcatenatedStringwithUniqueCharacters {
	
	public static void main(String[] args) {
		List<String> input = new ArrayList<>();
		input.add("un");
		input.add("iq");
		input.add("ue");
		int maxLength = maxLength(input);
		System.out.println(maxLength);
	}
	
	public static int maxLength(List<String> arr) {
        int n = arr.size();
        return dp(arr,0,"",n);

    }

    public static boolean hasDup(String s1,String s2){
        int[] freq = new int[26];
        for(char ch: s1.toCharArray()){
            if(freq[ch-'a'] > 0) return true;
            freq[ch-'a']++;
        }
        for(char ch: s2.toCharArray()){
            if(freq[ch-'a']>0) return true;
        }

        return false;
    }

    public static int dp(List<String> arr,int i,String temp,int n){
        if(i>= n) return temp.length();
        int include = 0;
        int exclude = 0;
        

        if(hasDup(arr.get(i),temp)){
            exclude = dp(arr,i+1,temp,n);
        }else{
            include = dp(arr,i+1,temp+arr.get(i),n);
            System.out.println(include);
            exclude =dp(arr,i+1,temp,n);
            System.out.println(exclude);
        }
        
        
        return Math.max(include,exclude);
    }

}
