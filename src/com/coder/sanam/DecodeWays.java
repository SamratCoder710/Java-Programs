package com.coder.sanam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DecodeWays {
	private static Map<Integer,Integer> dp = new HashMap<>();
	private static Set<Character> chArray = new HashSet<>(Arrays.asList('0','1','2','3','4','5'));
	public static int numDecodings(String s) {
		
		return decode(0,s);
        
    }
	
	public static int decode(int i,String s) {
		
		if(dp.containsKey(i)) {
			return dp.get(i);
		}
		if(s.charAt(i) == '0') {
			return 1;
		}
		int res = decode(i+1,s);
		if(i+1<s.length() && (s.charAt(i)=='1' || s.charAt(i)=='2' && chArray.contains(s.charAt(i+1)))){
			res += decode(i+2,s);
		}
		dp.put(i, dp.getOrDefault(i, 0));
		return res;
	}
	
	public static void main(String[] args) {
		int numDecodings = numDecodings("226");
		System.out.println(numDecodings);
	}
	
	

}
