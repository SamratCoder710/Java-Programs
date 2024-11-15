package com.coder.sanam;

import java.util.Stack;

public class QueueUsingStacks {
	
	Stack<Integer> s1 ;
	Stack<Integer> s2 ;
	public QueueUsingStacks() {
        s1 = new Stack<>();
        
        s2 = new Stack<>();
        
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
    	if(s2.isEmpty()) {
    	while(!s1.isEmpty()) {
    		Integer removedFromS1 = s1.pop();
    		s2.push(removedFromS1);
    	}}
		return s2.pop();
    	
    }
    
	public int peek() {
		if (s2.isEmpty()) {
			while (!s1.isEmpty()) {
				Integer removedFromS1 = s1.pop();
				s2.push(removedFromS1);
			}
		}
		return s2.peek();
	}
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

}
