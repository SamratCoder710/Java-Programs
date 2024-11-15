package com.coder.sanam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {
	
	public static List<String> letterCombinations(String digits) {
        Map<Character,String> combMap = new HashMap<>();
        combMap.put('2', "abc");
        combMap.put('3', "def");
        combMap.put('4', "ghi");
        combMap.put('5', "jkl");
        combMap.put('6', "mno");
        combMap.put('7', "pqrs");
        combMap.put('8', "tuv");
        combMap.put('9', "wxyz");
        
        List<String> result = new ArrayList<>();
        backtrack(0,"",result,digits,combMap);
        return result;      
    }

	private static void backtrack(int i, String currStr, List<String> result,String digits,Map<Character,String> combMap) {
		if(currStr.length() == digits.length()) {
			result.add(currStr);
			return;
		}
		for(char ch : combMap.get(digits.charAt(i)).toCharArray()) {
			backtrack(i+1,currStr+ch,result,digits,combMap);
		}
		
	}
	
	public static void main(String[] args) {
		List<String> letterCombinations = letterCombinations("2");
		System.out.println(letterCombinations);
	}

}
