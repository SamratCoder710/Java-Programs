package com.coder.sanam;

public class MinLengthAfterDeletingSimilarEnds {
	
	public static int minimumLength(String s) {
        int i=0;
        int j = s.length()-1;
        char tempChar = '0';
        int result = s.length();
        while(i<j){
        	 
            if(s.charAt(i) == s.charAt(j)){
                result-=2;
                tempChar = s.charAt(i);
                i++;
                j--;
            }else {
            	if(s.charAt(i) == tempChar ){
                    result-=1;
                    i++;
                }else if(s.charAt(j) == tempChar ){
                    result-=1;
                    j--;
                }else {
                	return result;
                }
            }
           
        }
        return result;
    }
	
	public static void main(String[] args) {
		int minimumLength = minimumLength("abbbbbbbbbbbbbbbbbbba");
		System.out.println(minimumLength);
	}

}
