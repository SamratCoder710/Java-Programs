package com.coder.sanam;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	
	public static int romanToInt(String s) {
        Map<Character,Integer> valueMap = new HashMap<>();
        valueMap.put('I',1);
        valueMap.put('V',5);
        valueMap.put('X',10);
        valueMap.put('L',50);
        valueMap.put('L',100);
        valueMap.put('C',500);
        valueMap.put('M',1000);
        int count = 0;
        char[] charArray = s.toCharArray();
        for(int i=0;i<charArray.length;i++){
        	if(i-1>=0 &&  valueMap.get(charArray[i]) > valueMap.get(charArray[i-1]) ) {
        		count += (valueMap.get(charArray[i]) - 2*(valueMap.get(charArray[i-1])));
        	}else {
        		count += valueMap.get(charArray[i]);
        	}
            
        }
        return count;

        
    }
	
	public static void main(String[] args) {
		int romanToInt = romanToInt("LVIII");
		System.out.println(romanToInt);
	}

}
