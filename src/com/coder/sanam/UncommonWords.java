package com.coder.sanam;

import java.util.*;
import java.util.stream.Collectors;

public class UncommonWords {

    public static void main(String[] args) {
        String[] strings = uncommonFromSentences("this apple is sweet", "this apple is sour");
        System.out.println(strings);
    }

    public static String[] uncommonFromSentences(String s1, String s2) {
        String s = s1+" "+s2;
        String[] arr  = s.split(" ");
        Map<String, Integer> collect = Arrays.stream(arr).collect(Collectors.toMap(a -> a, a -> Collections.frequency(List.of(arr), a),(a,b)-> a));
        Set<String> collect1 = collect.entrySet().stream().filter(e -> e.getValue() == 1).map(e -> e.getKey()).collect(Collectors.toSet());
        return collect1.toArray(String[]::new);
    }



}

