package com.coder.sanam;

import java.util.Arrays;

public class LongestCommonPrefix {
	public String longestCommonPrefixOptimal(String[] v) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(v);
        String first = v[0];
        String last = v[v.length-1];
        for (int i=0; i<Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }
	
	
	public static String longestCommonPrefix(String[] strs) {
		Arrays.sort(strs);
		for(String s:strs) {
			System.out.println(s);
		}
        String result = new String();
        for(int i=0;i<strs[0].length();i++){
            for(String s : strs){
                if(i==s.length() || s.charAt(i) != strs[0].charAt(i)){
                    return result;
                }
                
            }
            result += strs[0].charAt(i);

        }
        return result;
    }
	
	public static void main(String[] args) {
		 String longestCommonPrefix = longestCommonPrefix(new String[]{"flower","flow","flight"});
		 System.out.println(longestCommonPrefix);
		 
	}

}
