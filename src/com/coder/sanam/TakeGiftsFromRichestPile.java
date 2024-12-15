package com.coder.sanam;

import java.util.Collections;
import java.util.PriorityQueue;

public class TakeGiftsFromRichestPile {

    public static void main(String[] args) {
        long l = pickGifts(new int[]{25, 64, 9, 4, 100}, 4);
        System.out.println(l);
    }

    public static long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i :gifts){
            pq.add(i);
        }
        while(k>0 && !pq.isEmpty()){
            Integer peek = pq.poll();
            int floor = (int) Math.floor(Math.sqrt(peek * 1.0));
            pq.add(floor);
            k--;
        }
        long result = 0;
        while(!pq.isEmpty()){
            result += pq.poll();
        }
        return result;
    }
}
