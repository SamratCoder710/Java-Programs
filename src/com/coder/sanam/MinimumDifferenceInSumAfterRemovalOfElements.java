package com.coder.sanam;

import java.util.Collections;
import java.util.Optional;
import java.util.PriorityQueue;

public class MinimumDifferenceInSumAfterRemovalOfElements {

    public static void main(String[] args) {
        MinimumDifferenceInSumAfterRemovalOfElements minimumDifferenceInSumAfterRemovalOfElements = new MinimumDifferenceInSumAfterRemovalOfElements();
        long l = minimumDifferenceInSumAfterRemovalOfElements.minimumDifference(new int[]{7,9,5,8,1,3});
        System.out.println(l);

    }

    public long minimumDifference(int[] nums) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        int size = nums.length;
        int n = size/3;
        long[] rightSum = new long[size];
        for(int j=size-1;j>=0;j--){
            minHeap.offer((long) nums[j]);
            if(minHeap.size() == n){
                Long sum = minHeap.stream().reduce(Long::sum).orElse(0L);
                rightSum[j] = sum;
            }else if(minHeap.size() == n+1){
                minHeap.poll();
                Long sum = minHeap.stream().reduce(Long::sum).orElse(0L);
                rightSum[j] = sum;
            }
        }

        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long[] leftSum = new long[size];
        for(int i=0;i<size;i++){
            maxHeap.offer((long) nums[i]);
            if(maxHeap.size() == n){
                Long sum = maxHeap.stream().reduce(Long::sum).orElse(0L);
                leftSum[i] = sum;
            }else if(maxHeap.size() == n+1){
                maxHeap.poll();
                Long sum = maxHeap.stream().reduce(Long::sum).orElse(0L);
                leftSum[i] = sum;
            }
        }
        long min = Long.MAX_VALUE;
        for(int i=n-1;i<size-n;i++){
            min = Math.min(min,leftSum[i]- rightSum[i+1]);
        }
        return min;
    }


    public long minimumDifference_optimal(int[] nums) {
        int size = nums.length;
        int n = size / 3;

        // Left part: max-heap to track smallest n elements
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long[] leftSum = new long[size];
        long leftTotal = 0;

        for (int i = 0; i < size; i++) {
            maxHeap.offer(nums[i]);
            leftTotal += nums[i];

            if (maxHeap.size() > n) {
                leftTotal -= maxHeap.poll();
            }

            if (i >= n - 1) {
                leftSum[i] = leftTotal;
            }
        }

        // Right part: min-heap to track largest n elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long[] rightSum = new long[size];
        long rightTotal = 0;

        for (int i = size - 1; i >= 0; i--) {
            minHeap.offer(nums[i]);
            rightTotal += nums[i];

            if (minHeap.size() > n) {
                rightTotal -= minHeap.poll();
            }

            if (i <= size - n) {
                rightSum[i] = rightTotal;
            }
        }

        // Calculate the minimum difference
        long minDifference = Long.MAX_VALUE;
        for (int i = n - 1; i < size - n; i++) {
            minDifference = Math.min(minDifference, leftSum[i] - rightSum[i + 1]);
        }

        return minDifference;
    }
}

