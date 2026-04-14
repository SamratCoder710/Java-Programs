package com.coder.sanam;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SecondRepeatedCharacter {

    public static void main(String[] args) {
        String s= "sshubham";
        Map<Character,Long> mp = s.chars().mapToObj(x -> (char)x).
                collect(Collectors.groupingBy(x -> x,LinkedHashMap::new,Collectors.counting()));
        // repeated
        System.out.println(mp);
        List<Character> characters = mp.entrySet().stream().filter(x -> x.getValue() > 1).map(x -> x.getKey()).collect(Collectors.toList());
        Character ch = characters.get(1);

        //Alternative
        Character c = s.chars().mapToObj(x -> (char)x).
                collect(Collectors.groupingBy(x -> x,LinkedHashMap::new,Collectors.counting())).entrySet().stream()
                .filter(x -> x.getValue() > 1).map(x -> x.getKey()).skip(1).findFirst().orElseGet(null);

        System.out.println(c);
    }
}
