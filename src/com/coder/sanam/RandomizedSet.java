package com.coder.sanam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedSet {
	private Map<Integer,Integer> numsMap;
    private List<Integer> numsList;
    public RandomizedSet() {
        numsMap = new HashMap<>();
        numsList = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(search(val)) return false;
        numsList.add(val);
        numsMap.put(val,numsList.size()-1);
        
        return true;
    }
    
    public boolean search(int val){
        return numsMap.containsKey(val);
    }
    public boolean remove(int val) {
    	if(!search(val)) return false;
        int index = numsMap.get(val);
        numsList.set(index, numsList.get(numsList.size() - 1));
        numsMap.put(numsList.get(index), index);
        numsList.remove(numsList.size() - 1);
        numsMap.remove(val);
        
        return true;
    }
    
    public int getRandom() {
        Random rand = new Random();
        return numsList.get(rand.nextInt(numsList.size()));
    }


}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */