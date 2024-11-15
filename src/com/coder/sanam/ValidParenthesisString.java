package com.coder.sanam;

public class ValidParenthesisString {
	
	public static boolean checkValidString(String s) {
		int leftMin = 0, leftMax = 0;
		for(char ch:s.toCharArray()) {
			if(ch == '(') {
				leftMin += 1;
				leftMax += 1;
			}else if(ch == ')') {
				leftMin -= 1;
				leftMax -= 1;
			}else {
				leftMin -= 1;
				leftMax += 1;
			}
			if(leftMin < 0) {
				leftMin = 0;
			}
			if(leftMax < 0) {
				return false;
			}
		}
		return leftMin == 0;
    }

	
	
	public static void main(String[] args) {
		boolean checkValidString = checkValidString("(*))");
		System.out.println(checkValidString);
	}

	

}
