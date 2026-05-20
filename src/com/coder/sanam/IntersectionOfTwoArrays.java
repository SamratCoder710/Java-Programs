package com.coder.sanam;

import java.util.*;

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();
        int[] result = intersectionOfTwoArrays.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public int[] intersection(int[] n1, int[] n2) {
        Arrays.sort(n1);
        Arrays.sort(n2);

        int m = n1.length;
        int n = n2.length;

        int i = 0;
        int j = 0;

        Set<Integer> set = new HashSet<>();
        while (i < m && j < n) {
            if (n1[i] == n2[j]) {
                set.add(n1[i]);
                i++;
                j++;
            } else if (n1[i] < n2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] result = new int[set.size()];
        int k = 0;
        for (int num : set) {
            result[k] = num;
            k++;
        }
        return result;
    }
}
