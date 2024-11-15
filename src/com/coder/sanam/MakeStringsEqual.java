package com.coder.sanam;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MakeStringsEqual {
	
	public static boolean makeEqualEfficient(String[] words) {

	      if (words.length == 1) {
				return true;
			}
			int totalCharCount = 0;
			for (String s : words) {
				totalCharCount += s.length();
			}
			if (totalCharCount % words.length != 0) {
				return false;
			}

			int[] myMap = new int[26];
			for (String s : words) {
				for (char c : s.toCharArray()) {
					
					myMap[c - 'a']++;
				}
			}
			
			for (int i : myMap) {
				System.out.println(i);
				if (i % words.length != 0) {
					return false;
				}
			}
			return true; 
	}
	
	public static boolean makeEqual(String[] words) {
        Map<Character,Integer> indexMap = new HashMap<>();
        int noOfWords = words.length;
        if(noOfWords == 1) return true;
        for(int i=0;i<noOfWords;i++){
            for(char ch: words[i].toCharArray()){
                if(indexMap.containsKey(ch)) {
                	indexMap.put(ch, indexMap.get(ch)+1);
                }else {
                	indexMap.put(ch,1);
                }
            }
        }
        for(Integer x: indexMap.values()){
            if(x% noOfWords != 0){
                return false;
            }
        }
        
       return true;
    }
	
	public static void main(String[] args) {
		boolean isEqual = makeEqualEfficient(new String[] {"abcz","aabcz","bcz"});
	    System.out.println(isEqual);
		
	}

}
