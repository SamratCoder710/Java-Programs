package com.coder.sanam;

import java.util.*;

public class ClosestEqualElementQueries {

    public static void main(String[] args) {
        ClosestEqualElementQueries closestEqualElementQueries = new ClosestEqualElementQueries();
        List<Integer> result = closestEqualElementQueries.solveQueries(new int[]{1, 3, 1, 4, 1, 3, 2},
                new int[]{0, 3, 5});
        System.out.println(result);
    }


    public List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        int numLength = nums.length;
        for (int i = 0; i < nums.length; i++) {
            mp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> result = new ArrayList<>();
        for (int query : queries) {
            int ele = nums[query];
            List<Integer> list = mp.get(ele);
            int n = list.size();
            if (n == 1) {
                result.add(-1);
                continue;
            }
            int idx = binarySearch(list, query);

            int l = list.get((idx == 0) ? n - 1 : idx - 1);
            int r = list.get((idx == n - 1) ? 0 : idx + 1);
            int v = list.get(idx);

            int linearDistL = Math.abs(v - l);
            int linearDistR = Math.abs(v - r);

            // Now find the minimum of the linear and wrap-around distances
            int leftDist = Math.min(linearDistL, numLength - linearDistL);
            int rightDist = Math.min(linearDistR, numLength - linearDistR);


            result.add(Math.min(leftDist, rightDist));

        }

        return result;


    }

    private int binarySearch(List<Integer> list, int target) {
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) == target) {
                return mid;
            } else if (list.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }


}
