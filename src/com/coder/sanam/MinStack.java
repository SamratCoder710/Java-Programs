package com.coder.sanam;

import java.util.*;

class MinStack {
    List<Integer> numsList;
    PriorityQueue<Integer> sortedQueue;
    
    public MinStack() {
        numsList = new ArrayList<>();
        sortedQueue = new PriorityQueue<>();
    }
    
    public void push(int val) {
        numsList.add(val);
        sortedQueue.add(val);
    }
    
    public void pop() {
        Integer remove = numsList.remove(numsList.size()-1);
        sortedQueue.remove(remove);
    }
    
    public int top() {
    	return numsList.get(numsList.size()-1);
        
    }
    
    public int getMin() {
        return sortedQueue.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
