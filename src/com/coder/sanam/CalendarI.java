package com.coder.sanam;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class CalendarI {
    Map<Integer,Integer> map;

    public CalendarI() {
        map= new TreeMap<>();
    }

    public boolean book(int start, int end) {
        map.put(start,map.getOrDefault(start,0)+1);
        map.put(end,map.getOrDefault(end,0)-1);
        int sum = 0;
        for(Map.Entry<Integer, Integer> mp :map.entrySet()){
            sum += mp.getValue();
            if(sum>1){
                map.put(start,map.getOrDefault(start,0)-1);
                map.put(end,map.getOrDefault(end,0)+1);
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
