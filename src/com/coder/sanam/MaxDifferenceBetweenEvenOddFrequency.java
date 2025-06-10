package com.coder.sanam;



public class MaxDifferenceBetweenEvenOddFrequency {

    private final String question = """
            You are given a string s consisting of lowercase English letters.
            
            Your task is to find the maximum difference diff = freq(a1) - freq(a2) between the frequency of characters a1 and a2 in the string such that:
            
            a1 has an odd frequency in the string.
            a2 has an even frequency in the string.
            Return this maximum difference.
            """;

    public static void main(String[] args) {
        MaxDifferenceBetweenEvenOddFrequency maxDiff = new MaxDifferenceBetweenEvenOddFrequency();
        System.out.println(maxDiff.question);
        int i = maxDiff.maxDifference("aaaaabbc");
        System.out.println(i);
    }

    public int maxDifference(String s) {
        int [] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        int oddMax = 0;
        int evenMin = s.length()+1;
        for(int i: freq){
            if(i==0) continue;

            if(i %2 == 0){
                evenMin = Math.min(evenMin,i);
            }else{
                oddMax = Math.max(oddMax,i);
            }

        }
        return oddMax -evenMin;
    }
}
