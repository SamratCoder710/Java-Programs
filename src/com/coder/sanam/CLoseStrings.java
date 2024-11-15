package com.coder.sanam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CLoseStrings {
	public static boolean closeStrings(String word1, String word2) {
        char[] word1Arr = word1.toCharArray(),word2Arr = word2.toCharArray();
        if(word1Arr.length != word2Arr.length) return false;
        Map<Character,Integer> index1Map = new HashMap<>();
        Map<Character,Integer> index2Map = new HashMap<>();
        for(int i=0;i<word1Arr.length;i++){
            index1Map.put(word1Arr[i],index1Map.getOrDefault(word1Arr[i],0)+1);
            index2Map.put(word2Arr[i],index2Map.getOrDefault(word2Arr[i],0)+1); 
        }
        System.out.println("index 1 Map"+index1Map);
        System.out.println("index 1 keys:"+index1Map.keySet());
        System.out.println("index 1 values:"+index1Map.values());
        System.out.println("index 2 Map"+index2Map);

        System.out.println("index 2 keys:"+index2Map.keySet());
        System.out.println("index 2 values:"+index2Map.values());
        
        ArrayList<Integer> arrayList = new ArrayList<>(index1Map.values());
        ArrayList<Integer> array2List = new ArrayList<>(index2Map.values());
        
        Collections.sort(arrayList);
        Collections.sort(array2List);
        return index1Map.keySet().equals(index2Map.keySet()) && arrayList.equals(array2List);
    }
	
	public static void main(String[] args) {
		boolean closeStrings = closeStrings("aaabbbbccddeeeeefffff", "aaaaabbcccdddeeeeffff");
		System.out.println(closeStrings);
	}
}
