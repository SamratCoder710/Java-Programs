package com.coder.sanam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UniqueNoOfOccurences {
	
	public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            freqMap.put(arr[i],freqMap.getOrDefault(arr[i],0)+1);
        }
        Object[] array = freqMap.values().toArray();
        Arrays.sort(array);
        
        for(int i=0;i<array.length-1;i++){
            if(array[i] == array[i+1]) return false;
        }
        return true;
    }

	public static void main(String[] args) {
		boolean uniqueOccurrences = uniqueOccurrences(new int[] {1,2,1,});
		System.out.println(uniqueOccurrences);
	}
}
