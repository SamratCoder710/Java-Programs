package com.coder.sanam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams{
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String str : strs) {
            // Sort the characters in the string to get a unique key for anagrams
            char[] charArray = str.toCharArray();
            System.out.println("sorted::"+str);
            Arrays.sort(charArray);
            String sortedKey = new String(charArray);
            System.out.println("sortedKey::"+sortedKey);

            // Add the word to the corresponding group
            anagramGroups.computeIfAbsent(sortedKey, k -> new ArrayList<>()).add(str);
        }

        // Convert the values of the map to a List of Lists
        return new ArrayList<>(anagramGroups.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result = groupAnagrams(strs);

        // Print the result
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}

