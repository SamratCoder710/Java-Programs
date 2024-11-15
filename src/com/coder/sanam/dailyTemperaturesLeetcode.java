package com.coder.sanam;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class dailyTemperaturesLeetcode {
	
    public static int[] dailyTemperatures(int[] arr) {
    	Stack<Integer> st = new Stack<>();
    	int[] result = new int[arr.length];
    	for(int i = arr.length - 1;i>=0;i--) {
    		while(!st.isEmpty() && arr[i]>= arr[st.peek()]) {
    			st.pop();
    		}
    		if(!st.isEmpty()) {
    			result[i] = st.peek() - i;
    		}
    		st.push(i);
    	}
    	return result;
    }


	
	public static void main(String[] args) {
		int[] dailyTemperatures = dailyTemperatures(new int[] {73,74,75,71,69,72,76,73});
		
		for(int x: dailyTemperatures) {
			System.out.print(x+"::");
		}
	}

}
