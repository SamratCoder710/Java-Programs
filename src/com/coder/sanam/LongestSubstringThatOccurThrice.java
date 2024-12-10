package com.coder.sanam;

import java.util.*;


class CharPair{
    Character ch;
    Integer len;

    public CharPair(Character ch, Integer len) {
        this.ch = ch;
        this.len = len;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        CharPair obj = (CharPair) o;
        return ch == obj.ch && Objects.equals(len, obj.len);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ch, len);
    }

    @Override
    public String toString() {
        return "CharPair{" +
                "ch=" + ch +
                ", len=" + len +
                '}';
    }
}
public class LongestSubstringThatOccurThrice {

    public static void main(String[] args) {
        int i = maximumLength("aaaa");
        System.out.println(i);
    }

    public static int maximumLength(String s) {
        int n = s.length();
        int[][] arr = new int[26][n+1];
        int prevChar = s.charAt(0);
        int len = 0;
        for(int i=0;i<n;i++){
            char currChar = s.charAt(i);
            if(currChar == prevChar){
                len++;
                arr[currChar - 'a'][len]++;
            }else{
                len = 1;
                arr[currChar - 'a'][len]++;
                prevChar = currChar;
            }
        }

        System.out.println(arr);

        int result  = -1;
        for(int i=0;i<26;i++){
            int cumSum = 0;
            for(int j=n;j>=1;j--){
                cumSum += arr[i][j];
                if(cumSum >= 3){
                    result = Math.max(result,j);
                    break;
                }
            }
        }
        return result;

    }

    public static int maximumLengthBruteForce(String s) {
        int n = s.length();
        Map<String,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            String curr = "";
            for(int j = i;j<n;j++){
                if(curr.isEmpty() || curr.charAt(curr.length()-1) == s.charAt(j) ){
                    curr += s.charAt(j);
                    mp.merge(curr,1,Integer::sum);
                }else{
                    break;
                }
            }
        }
        System.out.println(mp);
        Optional<String> max = mp.entrySet().stream()
                .filter(a -> a.getValue() >= 3)
                .map(Map.Entry::getKey)
                .max(Comparator.comparing(String::length));
        return max.map(String::length).orElse(-1);

    }

    public static int maximumLengthBruteForceOptimized(String s) {
        int n = s.length();
        Map<CharPair,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            char currChar = s.charAt(i);
            int l = 0;
            for(int j = i;j<n;j++){
                if(l==0 || currChar == s.charAt(j) ){
                    l++;
                    mp.merge(new CharPair(currChar,l),1,Integer::sum);
                }else{
                    break;
                }
            }
        }
        System.out.println(mp);
        int result = -1;
        for(Map.Entry<CharPair,Integer> ele : mp.entrySet() ){
            if(ele.getKey().len > result && ele.getValue() >=3){
                result = ele.getKey().len;
            }
        }
        return result;
    }

}
