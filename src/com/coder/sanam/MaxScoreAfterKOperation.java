package com.coder.sanam;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxScoreAfterKOperation {

    public static void main(String[] args) {
        long l = maxKelements(new int[]{1,10,3,3,3}, 3);
        System.out.println(l);
    }

    public static long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); //Max HEAP
        for(int i : nums){
            pq.offer(i);
        }
        long score = 0;

        while(k>0){
            int poll = pq.poll();
            score += poll;
            int i = (poll / 3) + (poll % 3 == 0 ? 0 : 1);
            pq.offer(i);
            k--;
        }

        return score;
    }
}
