package com.coder.sanam;

import java.util.*;

public class IntersectionOfTwoArraysII {

    public static void main(String[] args) {
        IntersectionOfTwoArraysII intersectionOfTwoArraysII = new IntersectionOfTwoArraysII();
        int[] result = intersectionOfTwoArraysII.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
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

        List<Integer> list = new ArrayList<>();
        while (i < m && j < n) {
            if (n1[i] == n2[j]) {
                list.add(n1[i]);
                i++;
                j++;
            } else if (n1[i] < n2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] result = new int[list.size()];
        int k = 0;
        for (int num : list) {
            result[k] = num;
            k++;
        }
        return result;
    }

}
