package com.coder.sanam;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ReversePolishNotation {
	public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s:tokens) {
        	if(s.equals("+")) {
        		stack.push(stack.pop() + stack.pop());
        	}else if(s.equals("-")){
        		int b = stack.pop();
        		int a = stack.pop();
        		stack.push(a-b);
        	}else if(s.equals("*")){
        		stack.push(stack.pop() * stack.pop());
        	}else if(s.equals("/")){
        		int b = stack.pop();
        		int a = stack.pop();
        		stack.push(a/b);
        	}else {
        		stack.push(Integer.valueOf(s));
        	}
        }
        return stack.pop();
    }
	
	public static void main(String[] args) {
		int evalRPN = evalRPN(new String[] {"2","1","+","3","*"});
		System.out.println(evalRPN);
	}
}
