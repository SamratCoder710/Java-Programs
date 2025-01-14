package com.coder.sanam;

public class MinimumLengthOfStringAfterOperations {

    public static void main(String[] args) {
        MinimumLengthOfStringAfterOperations minimumLengthOfStringAfterOperations = new MinimumLengthOfStringAfterOperations();
        int len = minimumLengthOfStringAfterOperations.minimumLength("aabccabba");
        System.out.println(len);
    }

    public int minimumLength(String s) {
        int[] freq = new int[26];
        for(char ch: s.toCharArray()){
            freq[ch-'a']++;
        }
        int len = 0;
        for(int i=0;i<26;i++){
            if(freq[i]>=3){
                int m = freq[i];
                while(m>=3){
                    m -= ((m/3)*2);
                }
                len += m;
            }else{
                len += freq[i];
            }
        }
        return len;
    }

    public int minimumLengthOptimized(String s) {
        int[] freq = new int[26];
        int deleted = 0;
        for(char ch: s.toCharArray()){
            freq[ch-'a']++;
            if(freq[ch-'a']==3){
                freq[ch-'a'] -= 2;
                deleted += 2;
            }
        }
        return s.length()-deleted;
    }


    public int minimumLengthMoreOptimized(String s) {
        int[] freq = new int[26];
        for(char ch: s.toCharArray()){
            freq[ch-'a']++;
        }

        int len = 0;
        for(int i=0;i<26;i++){
            if(freq[i] == 0) continue;

            if(freq[i]%2==0){
                len += 2;
            }else{
                len += 1;
            }
        }
        return len;
    }
}
