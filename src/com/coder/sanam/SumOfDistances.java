package com.coder.sanam;

import java.util.*;

public class SumOfDistances {

    public static void main(String[] args) {
        SumOfDistances sumOfDistances = new SumOfDistances();
        long[] distance = sumOfDistances.distance(new int[]{1, 3, 1, 1, 2});
        System.out.println(Arrays.toString(distance));

    }

    public long[] distance(int[] nums) {
        Map<Integer, List<Integer>> idxMap = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            idxMap.computeIfAbsent(nums[i],k -> new ArrayList<>()).add(i);
        }

        long[] result = new long[n];
        for(int i=0;i<n;i++){
            List<Integer> list = idxMap.get(nums[i]);
            long sum = 0;
            for(int j: list){
                sum += Math.abs(i-j);
            }
            result[i] = sum;
        }

        return result;
    }


    public long[] distanceAlternative(int[] nums) {
        Map<Integer, List<Integer>> idxMap = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            idxMap.computeIfAbsent(nums[i],k -> new ArrayList<>()).add(i);
        }

        long[] result = new long[n];
        for (List<Integer> list : idxMap.values()) {
            int m = list.size();
            long[] prefix = new long[m + 1];
            for (int i = 0; i < m; i++) {
                prefix[i + 1] = prefix[i] + list.get(i);
            }
            for (int i = 0; i < m; i++) {
                int idx = list.get(i);
                // Left sum: i * list[i] - prefix[i]
                // Right sum: (prefix[m] - prefix[i + 1]) - (m - i - 1) * list[i]
                long left = (long) i * list.get(i) - prefix[i];
                long right = (prefix[m] - prefix[i + 1]) - (long) (m - i - 1) * list.get(i);
                result[idx] = left + right;
            }
        }

        return result;
    }
}
