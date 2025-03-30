package com.coder.sanam;

import java.util.*;

public class PartitionLabels {

    public static void main(String[] args) {
        PartitionLabels partitionLabels = new PartitionLabels();
        System.out.println(partitionLabels.partitionLabels("ababcbacadefegdehijhklij"));
    }

    public List<Integer> partitionLabelsOptimal(String s) {
        Map<Character, Integer> lastOccurrence = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence.put(s.charAt(i), i);
        }

        List<Integer> result = new ArrayList<>();
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastOccurrence.get(s.charAt(i)));
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }

    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int firstIndex = 0;
        while(firstIndex < s.length()){
            int lastIndex = s.lastIndexOf(s.charAt(firstIndex));
            for(int i=firstIndex+1;i<lastIndex;i++){
                if(s.lastIndexOf(s.charAt(i)) > lastIndex){
                    lastIndex = s.lastIndexOf(s.charAt(i));
                }
            }

            result.add(lastIndex - firstIndex + 1);
            firstIndex = lastIndex +1;

        }
        return result;
    }
}
