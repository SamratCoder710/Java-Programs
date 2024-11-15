package com.coder.sanam;

import java.util.*;

public class Sample {

    public static void main(String[] args) {
        List<String> inputList = List.of("match");
        Map<String, String> map1 = new HashMap<>();

        map1.put("key1","something");

        map1.put("key2","match");

        map1.put("key3","another");

        Map<String, String> map2 = new HashMap<>();

        map2.put("key4","something");

        map2.put("key5","other");

        map2.put("key6","another");

        Map<String, String> map3 = new HashMap<>();

        map3.put("key7","this thing");

        map3.put("key8","match");

        map3.put("key9","one more");


        List<Map<String,String>> listOfMap = new ArrayList<>();
        listOfMap.add(map1);

        listOfMap.add(map2);

        listOfMap.add(map3);

        listOfMap.forEach( eleMap -> eleMap.forEach((key, value) -> {
            if (inputList.contains(value)) {
                System.out.println(key);
            }
        }));

        List<Integer> list= new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(6);
        list.add(1);
        list.add(2);
        list.add(7);
//
        Optional<Integer> first = list.stream().sorted(Comparator.reverseOrder()).skip(2).findFirst();
        System.out.println(first.get());
    }
}
