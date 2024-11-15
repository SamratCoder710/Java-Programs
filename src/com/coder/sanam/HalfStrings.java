package com.coder.sanam;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HalfStrings {
	
	public static boolean halvesAreAlike(String s) {
        int left = 0,right = s.length()-1 , leftEnd = s.length()/2 -1, rightStart = s.length()/2;
        int leftCounter = 0,rightCounter = 0;
        Set<Character> vowels = new HashSet<>(Set.of( 'a','e','i','o','u','A','E','I','O','U'));
        while(left <= leftEnd && right >= rightStart){
            if(vowels.contains(s.charAt(left))){
                leftCounter++;
                
            }
            if(vowels.contains(s.charAt(right))){
                rightCounter++;
                
            }
            left++;
            right--;
        }
        return leftCounter == rightCounter;
     }
	
	public static void main(String[] args) {
		System.out.println( halvesAreAlike("book"));
	}

}
