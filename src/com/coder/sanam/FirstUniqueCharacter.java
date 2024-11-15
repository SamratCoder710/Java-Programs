package com.coder.sanam;

import java.util.Arrays;

public class FirstUniqueCharacter {
	
	public static int firstUniqChar(String s) {
        int[] countArray = new int[26];
        Arrays.fill(countArray,0);
        for(int i=0;i<s.length();i++){
            countArray[s.charAt(i)- 'a']++;
        }
        for(int x:countArray) {System.out.print(x);}
        System.out.println();
        int result = -1;
        for(int i=0;i<26;i++){
            if(countArray[i]!=0){
                result++;
                if(countArray[i] == 1){
                    return result;
                }
            }
        }
        return result;
    }
	
	public static void main(String[] args) {
		int firstUniqChar = firstUniqChar("loveleetcode");
		System.out.println(firstUniqChar);
	}
	

}
