package com.coder.sanam;

import java.util.LinkedList;
import java.util.List;

public class AddToArrayFormOfInteger {

    public static void main(String[] args) {
        AddToArrayFormOfInteger addToArrayFormOfInteger = new AddToArrayFormOfInteger();
        List<Integer> integers = addToArrayFormOfInteger.addToArrayForm(new int[]{1, 2, 4, 0}, 34);
        System.out.println(integers);
    }

    public List<Integer> addToArrayForm(int[] num, int K) {
        List<Integer> res = new LinkedList<>();
        for (int i = num.length - 1; i >= 0; --i) {
            res.addFirst((num[i] + K) % 10);
            K = (num[i] + K) / 10;
        }
        while (K > 0) {
            res.addFirst(K % 10);
            K /= 10;
        }
        return res;
    }
}
