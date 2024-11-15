package com.coder.sanam;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestSortedElement {

    static class KthLargest {
        PriorityQueue<Integer> minHeap ;
        int index ;
        public KthLargest(int k, int[] nums) {
            minHeap = new PriorityQueue<>();
            for (int num : nums) {
                minHeap.offer(num);
                if (minHeap.size() > k) minHeap.poll();
            }
            index = k;
        }

        public int add(int val) {
            minHeap.offer(val);
            if(minHeap.size() > index) minHeap.poll();
            return minHeap.peek();
        }
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3,new int[]{4, 5, 8, 2});
        kthLargest.add(3);
        kthLargest.add(5);
        kthLargest.add(10);
        kthLargest.add(9);
        kthLargest.add(4);

    }
}
