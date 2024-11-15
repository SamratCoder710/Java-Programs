package com.coder.sanam;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	
	 public static List<String> generateParenthesis(int n) {
	     List<String> result = new ArrayList<>();
	     int openN = 0,closeN = 0;
	     String stack = "";
	     backtrack(openN,closeN,n, stack,result);
	     return result;
	 }

	private static void backtrack(int openN, int closeN, int n, String stack,List<String> result) {
		if(openN == closeN  && closeN == n) {
	    	 result.add(stack);
	    	 return;
	     }
		
		if(openN < n) {
			backtrack(openN +1, closeN, n, stack +"(", result);
		}
		
		if(closeN < openN) {
			backtrack(openN, closeN + 1, n, stack +")", result);
		}
		
		
	}
	
	public static void main(String[] args) {
		List<String> generateParenthesis = generateParenthesis(3);
		System.out.println(generateParenthesis);
		
	}

}
