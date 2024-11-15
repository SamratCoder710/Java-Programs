package com.coder.sanam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestClass {

    public static void main(String[] args) {
        String input = "Hello to World 1";
        char ch = 'o';
        String [] arr = input.split(" ");
        List<String> collect = Arrays.stream(arr).map(e -> e.replaceAll("o","")).toList();
        String collect1 = collect.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.joining(" "));
        System.out.println(collect1);


    }
}
