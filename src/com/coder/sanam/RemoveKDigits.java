package com.coder.sanam;

import java.util.Stack;

public class RemoveKDigits {
	
	public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for(char ch:num.toCharArray()) {
        	while(!stack.isEmpty() && k>0 && stack.peek() > ch) {
        		k-= 1;
        		stack.pop();
        	}
        	stack.push(ch);
        }
        while(k>0 && !stack.isEmpty()) {
        	stack.pop();
        	k -= 1;
        }
        StringBuilder sb = new StringBuilder();
        for(char ch:stack) {
        	sb.append(ch);
        }
        
        //remove leading zeroes
        while(sb.length()>0 && sb.charAt(0)=='0') {
        	sb.deleteCharAt(0);
        }
        return sb.length()>0 ? sb.toString(): "0";
    }
	
	public static void main(String[] args) {
		String removeKdigits = removeKdigits("1234567890", 9);
		System.out.println(removeKdigits);
	}

}
