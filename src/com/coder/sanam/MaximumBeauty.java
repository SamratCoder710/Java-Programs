package com.coder.sanam;

import java.util.*;

public class MaximumBeauty {

    public static void main(String[] args) {
        maximumBeauty(new int[][]{{1,2},{3,2},{2,4},{5,6},{3,5}},new int[]{1,2,3,4,5,6});
    }

    public static int[] maximumBeauty(int[][] items, int[] queries) {
        int currMax = items[0][1];
        int[] arr = new int[10^9];
        Arrays.sort(items, Comparator.comparing(a ->a[0]));
        for (int[] item : items) {
            int price = item[0];
            int beauty = item[1];
            arr[price] = Math.max(beauty,currMax);
            currMax = arr[price];
        }

        int[] res = new int[10^9];


        return new int[]{};
    }
}
