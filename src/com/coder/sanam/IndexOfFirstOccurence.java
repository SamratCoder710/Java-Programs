package com.coder.sanam;

import java.util.ArrayList;
import java.util.List;

public class IndexOfFirstOccurence {
	
	public static int strStr(String haystack, String needle) {
        int k = haystack.length();
        int m = needle.length();
        int output = -1;
        List<Integer> resultSet = new ArrayList<>();
        if(m > k) return output;
        for(int i=0;i<k;i++){
            if(haystack.charAt(i) == needle.charAt(0)){
            	System.out.println("Candidate index:: "+i);
                output = i;
                for(int j=1;j<m;j++){
                    if(i+j<k && haystack.charAt(i+j) != needle.charAt(j)){
                        output = -1;
                        break;
                    }else if(i+j<=k) {
                    	output = -1;
                        break;
                    }
                }
                if(output != -1) { resultSet.add(output);}
            }
        }
        return resultSet.size() != 0 ? resultSet.get(0) : -1;
    }
	
	public static void main(String[] args) {
		int strStr = strStr("mississippi","issipi");
		System.out.println(strStr);
	}

}
