package com.coder.sanam;

import java.util.Stack;

public class MinimumStringAfterRemovingSubStrings {

    public static void main(String[] args) {
        int i = optiMinLength("ABFCACDB");
        System.out.println(i);
    }

    public static int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        stack.push(s.charAt(0));
        int i = 1;
        while(i<n){
            if((!stack.isEmpty() && stack.peek() == 'A' && s.charAt(i) == 'B')|| ( !stack.isEmpty() && stack.peek() == 'C' && s.charAt(i) == 'D')){
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
            i++;
        }
        return stack.size();

    }


    public static int optiMinLength(String s) {
        int n = s.length();
        int i=0;int j=1;
        StringBuilder sb = new StringBuilder(s);
        while(j<n){
            if(i<0){
                i++;
                sb.setCharAt(i,sb.charAt(j));
            }else if(sb.charAt(i) == 'A' && sb.charAt(j) =='B' || sb.charAt(i) == 'C' && sb.charAt(j) == 'D'){
                i--;
            }else{
                i++;
                sb.setCharAt(i,sb.charAt(j));
            }
            j++;
        }
        return i+1;

    }
}
