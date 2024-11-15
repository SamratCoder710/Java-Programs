package com.coder.sanam;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
	
	public static boolean wordBreak(String s, List<String> wordDict) {
	       int index = s.length();
           boolean[] dp = new boolean[s.length()+1];
           dp[s.length()] = true;
	       while(index>=0){
	           for(String word:wordDict){
	               int len = word.length();
                   if(index+len <= s.length() && word.equals(s.substring(index,index+len))) {
                	   dp[index] = dp[index+len];
                   }
                   if(dp[index]) {
                	   break;
                   }
	               
	           }
	           index--;
	           
	       } 
	       return dp[0];
	    }
	
	public static void main(String[] args) {
		List<String> words = new ArrayList<>();
		words.add("leet");
		words.add("code");
		
		boolean wordBreak = wordBreak("leetcode", words);
		System.out.println(wordBreak);
	}

}
