package com.coder.sanam;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class NumberContainers {

    public static void main(String[] args) {
        NumberContainers numberContainers = new NumberContainers();
        numberContainers.change(2,7);          // The container with index 2 now contains 7
        numberContainers.change(1,7);          // The container with index 1 now contains 7
        numberContainers.change(3,7);          // The container with index 3 now contains 7
        int v1 = numberContainers.find(7);            // return 1. The smallest
        numberContainers.change(1,4);          // The container with index 1 now contains 4
        int v2 = numberContainers.find(7);            // return 2. The smallest
        System.out.println(v1);
        System.out.println(v2);

    }

    Map<Integer,Integer> indexNumberMap;
    Map<Integer, TreeSet<Integer>> numberIndexArrMap;

    public NumberContainers() {
        indexNumberMap = new HashMap<>();
        numberIndexArrMap = new HashMap<>();
    }

    public void change(int index, int number) {
        if(indexNumberMap.get(index) != null){
            int oldNumber = indexNumberMap.get(index);
            TreeSet<Integer> oldNumberIndexArr = numberIndexArrMap.get(oldNumber);
            oldNumberIndexArr.remove(index);
            if(oldNumberIndexArr.isEmpty()){
                numberIndexArrMap.remove(oldNumber);
            }else{
                numberIndexArrMap.put(oldNumber,oldNumberIndexArr);
            }
        }
        indexNumberMap.put(index,number);
        TreeSet<Integer> found = numberIndexArrMap.getOrDefault(number, new TreeSet<>());
        found.add(index);
        numberIndexArrMap.put(number,found);

    }

    public int find(int number) {
        if(numberIndexArrMap.get(number) == null) return -1;
        TreeSet<Integer> found = numberIndexArrMap.get(number);
        return !found.isEmpty() ? found.first() : -1;
    }
}
