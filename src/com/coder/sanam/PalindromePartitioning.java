package com.coder.sanam;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	
	private static List<List<String>> res = new ArrayList<>();
    public static List<List<String>> partition(String s) {
        dfs(s,0,new ArrayList<>());
        return res;
    }

    public static void dfs(String s,int i,List<String>part){
        if(i >= s.length()){
            res.add(new ArrayList<>(part));
            return;
        }
        for(int j=i;j<s.length();j++){
            if(isPalindrome(s,i,j)){
                part.add(s.substring(i,j+1));
                dfs(s,j+1,part);
                part.remove(part.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i += 1;
            j -= 1;
        }
        return true;
    }

    public static void main(String[] args) {
		List<List<String>> partition = partition("aab");
		for(List<String> k:partition) {
			for(String s:k) {
				System.out.print(s+"::");
			}
			System.out.println();
		}
	}
}
