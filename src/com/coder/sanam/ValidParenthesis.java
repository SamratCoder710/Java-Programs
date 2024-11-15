package com.coder.sanam;

import java.util.Stack;

public class ValidParenthesis {
	
	
	public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char ch:s.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(complementBracket(ch));
            }else if(stack.isEmpty() || stack.pop() != ch){
                return false;
            }
        }
        return true;
    }

	    private static char complementBracket(char ch){
	        if(ch == '(') return ')';
	        else if(ch == '[') return ']';
	        return '}';
	    }
	    
	    public static void main(String[] args) {
	    	boolean valid = isValid("([)]");
	    	System.out.println(valid);
		}
	    

}
