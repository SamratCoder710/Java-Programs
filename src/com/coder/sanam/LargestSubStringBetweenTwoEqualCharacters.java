package com.coder.sanam;

import java.util.Arrays;

public class LargestSubStringBetweenTwoEqualCharacters {
	
	public static int maxLengthBetweenEqualCharacters(String s) {
        int[] arr = new int[26];
        Arrays.fill(arr,-1);
        
        int largest = -1;
        for(int i=0;i<s.length();i++){
            if(arr[s.charAt(i) - 'a'] == -1){
                arr[s.charAt(i)-'a'] = i;
            }else{
            	largest = Math.max(largest,i- arr[s.charAt(i)-'a'] -1);
            }
            for(int m : arr) {
            	System.out.print(m);
            }
        }
        return largest;
    }
	
	public static void main(String[] args) {
		int maxLengthBetweenEqualCharacters = maxLengthBetweenEqualCharacters("aa");
		System.out.println("Max::"+maxLengthBetweenEqualCharacters);
	}

}
