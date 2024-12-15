package com.coder.sanam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Flatmap {

    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1,2,3);
        List<Integer> l2 = Arrays.asList(4,5);

        List<List<Integer>> list = l1.stream().flatMap(i -> l2.stream().map(j -> Arrays.asList(i, j))).toList();
        System.out.println(list);
    }
}
