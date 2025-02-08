package com.coder.sanam;

import java.util.*;

public class DesignNumberContainerSystem {

    static class NumberContainers {
        Map<Integer, Integer> indexNumberMap;
        Map<Integer, TreeSet<Integer>> numberIndexListMap;


        public NumberContainers() {
            indexNumberMap = new HashMap<>();
            numberIndexListMap = new HashMap<>();
        }

        public void change(int index, int number) {
            if(indexNumberMap.get(index) != null){
                Set<Integer> integers = numberIndexListMap.get(indexNumberMap.get(index));
                integers.remove(index);
            }
            indexNumberMap.put(index, number);
            if (numberIndexListMap.get(number) == null) {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(index);

                numberIndexListMap.put(number,set);
            } else {
                TreeSet<Integer> integers = numberIndexListMap.get(number);
                integers.add(index);
                numberIndexListMap.put(number,integers);
            }
        }

        public int find(int number) {
            if(numberIndexListMap.get(number) == null) return -1;
            TreeSet<Integer> integers = numberIndexListMap.get(number);
            return integers.first();
        }
    }

    /**
     * Your NumberContainers object will be instantiated and called as such:
     * NumberContainers obj = new NumberContainers();
     * obj.change(index,number);
     * int param_2 = obj.find(number);
     */

    public static void main(String[] args) {
        NumberContainers obj = new NumberContainers();
        System.out.println(obj.find(10)); // Should print -1
        obj.change(2, 10);
        obj.change(1, 10);
        obj.change(3, 10);
        obj.change(5, 10);
        System.out.println(obj.find(10)); // Should print 1
        obj.change(1, 20);
        System.out.println(obj.find(10)); // Should print 2
    }
}
