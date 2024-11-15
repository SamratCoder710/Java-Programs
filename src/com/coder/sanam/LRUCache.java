package com.coder.sanam;

import java.util.*;

class LRUCache {
    private Map<Integer,Integer> numsMap ;
    private int capacity;
    private List<Integer> numsList;
    public LRUCache(int capacity) {
         this.numsMap = new HashMap<>();
         this.numsList = new ArrayList<>();
         this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!search(key)) return -1;
        swap(key);
        return numsMap.get(key);
    }

    private void swap(int a) {
    	numsList.remove(numsList.indexOf(a));
		numsList.add(a);
	}

	public boolean search(int key){
        return numsMap.containsKey(key);
    }
    // 3 size    ,3:3 ,2:2 ;5:5
    public void put(int key, int value) {
    	 if(search(key)) {
    		 numsMap.put(key, value);
    		 swap(key);
    	 }
    	 else{
    		 if(numsList.size() == capacity){
    	            Integer removed = numsList.remove(0);
    	            numsMap.remove(removed);
    	            numsList.add(key);
    	            numsMap.put(key, value);
    	     }else {
    	        	numsList.add(key);
    	            numsMap.put(key, value);
    	     }
    	 }
    }
    
    public static void main(String[] args) {
    	LRUCache lRUCache = new LRUCache(3);
    	lRUCache.put(1,1); 
    	lRUCache.put(2,2); 
    	lRUCache.put(3,3);
    	lRUCache.put(4,4);
    	
    	System.out.println(lRUCache.get(4));   
    	
    	System.out.println(lRUCache.get(3));    
    	System.out.println(lRUCache.get(2)); 
    	System.out.println(lRUCache.get(1)); 
    	
    	lRUCache.put(5, 5); 
    	System.out.println(lRUCache.get(1));   
    	System.out.println(lRUCache.get(2));
    	System.out.println(lRUCache.get(3));    
    	System.out.println(lRUCache.get(4)); 
    	System.out.println(lRUCache.get(5)); 
	}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
