package com.coder.sanam;

import java.util.HashMap;
import java.util.Map;

public class MinimumHammingDistanceAfterSwapOps {

    public static void main(String[] args) {
        MinimumHammingDistanceAfterSwapOps minimumHammingDistanceAfterSwapOps = new MinimumHammingDistanceAfterSwapOps();
        int result = minimumHammingDistanceAfterSwapOps.minimumHammingDistance(
                new int[]{1, 2, 3, 4},
                new int[]{2, 1, 4, 5},
                new int[][]{{0, 1}, {2, 3}}
        );
        System.out.println(result);
    }


    int[] parent;
    int[] rank;

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootY] < rank[rootX]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i; // each node is its own parent
        }

        for (int[] swap : allowedSwaps) {
            union(swap[0], swap[1]);
        }

        Map<Integer, Map<Integer, Integer>> groupFreq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int curr = source[i];
            int parent = find(i); // group

            groupFreq
                    .computeIfAbsent(parent, k -> new HashMap<>())
                    .merge(curr, 1, Integer::sum);
        }

        int hammingDist = 0;
        for (int i = 0; i < n; i++) {
            int parent = find(i); // group
            int t = target[i];
            Map<Integer, Integer> value = groupFreq.getOrDefault(parent, new HashMap<>());
            if (value.containsKey(t)) {
                int eleFreq = value.get(t);
                if (eleFreq == 1) {
                    value.remove(t);
                } else {
                    value.put(t, eleFreq - 1);
                }
            } else {
                hammingDist++;
            }

        }

        return hammingDist;
    }

}
