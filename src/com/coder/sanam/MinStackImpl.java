package com.coder.sanam;

import java.util.Stack;

class MinStackClass {

    class Pair{
        int val;
        int minVal;
        public Pair(int val,int minVal){
            this.val = val;
            this.minVal = minVal;
        }

    }

    Stack<Pair> stack;
    public MinStackClass() {
        stack = new Stack<>();

    }

    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new Pair(val,val));
        }else{
            int min = Math.min(stack.peek().minVal,val);
            stack.push(new Pair(val,min));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        Pair p = stack.peek();
        return p.val;

    }

    public int getMin() {
        Pair p = stack.peek();
        return p.minVal;
    }
}

public class MinStackImpl {

}
