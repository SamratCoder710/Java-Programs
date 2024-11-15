package com.coder.sanam;

public class MinAddToMakeParenthesisValid {

    public static void main(String[] args) {
        int i = minAddToMakeValid("((()))");
        System.out.println(i);
    }

    public static int minAddToMakeValid(String s) {
        int open = 0;int mismatch = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                open++;
            }else{
                if(open>0){
                    open--;
                }else{
                    mismatch++;
                }
            }
        }
        return open + mismatch;
    }

}
