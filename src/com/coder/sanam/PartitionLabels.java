package com.coder.sanam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PartitionLabels {

    public static void main(String[] args) {
        PartitionLabels partitionLabels = new PartitionLabels();
        System.out.println(partitionLabels.partitionLabels("ababcbacadefegdehijhklij"));
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
