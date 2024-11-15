package com.coder.sanam;

import java.util.*;

public class LeastNumberOfUniqueIntegersAfterKremovals {
	
	public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int i =0;i<arr.length;i++){
            freqMap.put(arr[i],freqMap.getOrDefault(arr[i],0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        
        
        for(int value : freqMap.values()){
            list.add(value);
        }
        int cnt = 0;
        Collections.sort(list);
        for(int i=0;i<list.size();i++) {
        	if(k>list.get(i)) {
        		k -= list.get(i);
        		list.set(i, 0);
        	}else {
        		list.set(i,list.get(i)-k);
        		k=0;
        	}
        	if(list.get(i) != 0 ) {
        		cnt++;
        	}
        }
        return cnt;
    }
	
	public static void main(String[] args) {
		int findLeastNumOfUniqueInts = findLeastNumOfUniqueInts(new int[] {4,3,1,1,3,3,2}, 3);
		System.out.println(findLeastNumOfUniqueInts);
	}

}
