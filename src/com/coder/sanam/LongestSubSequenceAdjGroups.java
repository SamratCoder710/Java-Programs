package com.coder.sanam;

import java.util.ArrayList;
import java.util.List;

public class LongestSubSequenceAdjGroups {

    public static void main(String[] args) {
        LongestSubSequenceAdjGroups obj = new LongestSubSequenceAdjGroups();
        String[] words = {"h","vv","kp"};
        int[] groups = {0,1,0};
        System.out.println(obj.getLongestSubsequence(words, groups));
    }

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int idx = 0;
        List<String> result = new ArrayList<>();
        result.add(words[idx]);
        for(int i=1;i<groups.length;i++){
            if(groups[idx] != groups[i] ){
                idx = i;
                result.add(words[idx]);
            }
        }
        return result;
    }
}
