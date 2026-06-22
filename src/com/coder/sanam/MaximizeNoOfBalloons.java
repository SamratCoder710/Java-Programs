package com.coder.sanam;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MaximizeNoOfBalloons {

    static void main() {
        MaximizeNoOfBalloons maximizeNoOfBalloons = new MaximizeNoOfBalloons();
        int res = maximizeNoOfBalloons.maxNumberOfBalloons("loonbalxballpoon");
        System.out.println(res);
    }

    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        for(char ch : text.toCharArray()){
            freq[ch-'a']++;
        }
        int count = 0;
        boolean canAdd = true;
        while(canAdd){
            for(char c : "balloon".toCharArray()){
                if(freq[c - 'a'] <= 0){
                    canAdd = false;
                    break;
                }
                freq[c - 'a']--;
            }
            if(canAdd){
                count++;
            }

        }
        return count;
    }

    public int maxNumberOfBalloonsAlternative(String text) {
        Map<Character,Integer> freqMap = new HashMap<>();

        Set<Character> set = Set.of('b','a','l','o','n');

        for(char ch : text.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch,0)+1);
        }
        int count = 0;
        boolean canAdd = true;
        while(canAdd){
            for(char c : "balloon".toCharArray()){
                if(freqMap.getOrDefault(c,0) <= 0){
                    freqMap.remove(c);
                    canAdd = false;
                    break;
                }
                freqMap.put(c, freqMap.getOrDefault(c,0) - 1);
            }
            if(canAdd){
                count++;
            }

        }
        return count;

    }
}
