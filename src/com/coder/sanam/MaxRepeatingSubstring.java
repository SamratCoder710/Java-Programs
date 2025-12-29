package com.coder.sanam;

public class MaxRepeatingSubstring {

    public static void main(String[] args) {
        MaxRepeatingSubstring obj = new MaxRepeatingSubstring();
        String sequence = "aaabaaaabaaabaaaabaaaabaaaabaaaaba";
        String word = "aaaba";
        System.out.println(obj.maxRepeating(sequence, word));
    }

    public int maxRepeating(String sequence, String word) {
        int count = 0;
        StringBuilder sb = new StringBuilder(word);
        while(sequence.contains(sb.toString())){
            sb.append(word);
            count++;
        }

        return count;
    }
}
