package com.coder.sanam;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FinalArrayStateAfterKMultiplication {

    public static void main(String[] args) {
        int[] finalState = getFinalState(new int[]{2, 1, 3, 5, 6}, 5, 2);
        Arrays.stream(finalState).forEach(System.out::println);
    }

    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
            if(a[0] == b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        for(int i=0;i<n;i++){
            pq.add(new int[]{nums[i],i});
        }
        while(k>0){
            int[] arr  = pq.poll();
            int ele = arr[0];
            int idx = arr[1];
            pq.add(new int[]{ele * multiplier, idx});
            k--;
        }
        int[] res = new int[n];
        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            res[arr[1]] = arr[0];
        }
        return res;
    }

    //O(n)
    public int[] getFinalStateOptimized(int[] nums, int k, int multiplier) {
        int[] arr = new int[2];

        for (int i = 0; i < k; i++) {
            arr = getMin(nums);
            nums[arr[1]] = arr[0] * multiplier;
        }

        return nums;
    }

    private int[] getMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int idx = 0;

        for (int i = 0; i < nums.length; i++)
            if (nums[i] < min) {
                min = nums[i];
                idx = i;
            }

        return new int[] { min, idx };
    }
}
