package com.coder.sanam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NumberOfSmallestUnoccupiedChairs {

    public static void main(String[] args) {
        System.out.println(smallestChair(new int[][]{{3,10},{1,5},{2,6}}, 0));
    }

    public static int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        Integer[] indexes = new Integer[n];
        PriorityQueue<Integer> available_chairs = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            indexes[i] = i;
            available_chairs.offer(i);
        }
        Arrays.sort(indexes, Comparator.comparingInt(a -> times[a][0]));
        PriorityQueue<int[]> used_chairs = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));//(l,chair)

        for(int i: indexes){
            int arr = times[i][0];
            int leave = times[i][1];

            while(!used_chairs.isEmpty() && used_chairs.peek()[0] <= arr){
                int[] used = used_chairs.poll();
                available_chairs.offer(used[1]);
            }

            Integer chair = available_chairs.poll();
            used_chairs.offer(new int[]{leave,chair});

            if(i == targetFriend) return chair;
        }
        return -1;

    }
}
