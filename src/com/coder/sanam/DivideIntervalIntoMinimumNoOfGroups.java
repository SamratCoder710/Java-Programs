package com.coder.sanam;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DivideIntervalIntoMinimumNoOfGroups {

    public static void main(String[] args) {
        System.out.println(minGroups(new int[][]{{5,10},{6,8},{1,5},{2,3},{1,10}}));
    }

    public static int minGroups(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        for(int[] arr:intervals){
            int start = arr[0];
            int end = arr[1];

            if(!pQueue.isEmpty() && pQueue.peek()<start){
                pQueue.poll();
            }
            pQueue.offer(end);
        }
        return pQueue.size();
    }
}
