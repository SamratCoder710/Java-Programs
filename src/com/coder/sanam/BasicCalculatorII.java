package com.coder.sanam;

import java.util.Stack;

public class BasicCalculatorII {
	
	public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char op = '+';
        int number = 0;
        char[] ch = s.toCharArray();
        for(int i=0;i<s.length();i++) {
        	if(Character.isDigit(ch[i])) {
        		number = number * 10 + (ch[i] - '0');
        	}
        	
        	if(!Character.isDigit(ch[i]) && ch[i]!= ' ' || i == ch.length - 1) {
        		if(op == '+') {
        			stack.push(number);
        		}else if(op == '-') {
        			stack.push(-number);
        		}else if(op == '*') {
        			stack.push(stack.pop() * number);
        		}else if(op == '/') {
        			stack.push(stack.pop() / number);
        		}
        		op = ch[i];
        		number = 0;
        	}
        }
        int sum = 0;
        while(!stack.isEmpty()) {
        	sum+= stack.pop();
        }
        return sum;
    }
	
	public static void main(String[] args) {
		int calculate = calculate("  3+2*2 ");
		System.out.println(calculate);
	}
	
	

}
