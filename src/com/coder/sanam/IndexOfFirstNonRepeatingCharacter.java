package com.coder.sanam;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IndexOfFirstNonRepeatingCharacter {

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingCharacterIndexUsingStream("abcckff"));
    }

    public static int firstNonRepeatingCharacterIndex(String s){
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(s.indexOf(ch) == s.lastIndexOf(ch)){
                return i;
            }
        }
        return -1;
    }

    public static int firstNonRepeatingCharacterIndexUsingStream(String s){
        String[] split = s.split("");
        Map<String, Integer> collect = Arrays.stream(split).collect(Collectors.toMap(a -> a, a -> Collections.frequency(List.of(split), a),(a,b)-> a, LinkedHashMap::new));
        String firstKeyWithOne = collect.entrySet().stream()
                .filter(entry -> entry.getValue() == 1) // Filter by value == 1
                .map(Map.Entry::getKey)                 // Extract the key
                .findFirst()                            // Get the first match
                .orElse(null);
        if(firstKeyWithOne == null){
            return -1;
        }
        return s.indexOf(firstKeyWithOne);



    }

    public static int firstNonRepeatIndex(String s){
        String[] split = s.split("");
        LinkedHashMap<String, Long> collect = Arrays.stream(split).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        Map.Entry<String, Long> stringLongEntry = collect.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst().orElse(null);
        if(stringLongEntry == null){
            return -1;
        }
        return s.indexOf(stringLongEntry.getKey());
    }
}
