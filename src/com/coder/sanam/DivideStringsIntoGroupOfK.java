package com.coder.sanam;

import java.util.Arrays;

public class DivideStringsIntoGroupOfK {

    public static void main(String[] args) {
        DivideStringsIntoGroupOfK divideStringsIntoGroupOfK = new DivideStringsIntoGroupOfK();
        String[] strings = divideStringsIntoGroupOfK.divideStringOptimal("abcdefghi", 3, 'x');
        Arrays.stream(strings).forEach(System.out::println);
    }

    public String[] divideString(String s, int k, char fill) {
        int size = s.length();
        int mod = size%k;
        int fillCount = mod != 0 ? k - mod : 0  ;
        String newString = s + String.valueOf(fill).repeat(fillCount);
        size = size + fillCount;
        String[] result = new String[size/k];
        int count = 0;
        for(int i=0;i<size;i+=k){
            StringBuilder sb = new StringBuilder();
            for(int j=i;j<i+k;j++){
                sb.append(newString.charAt(j));
            }
            result[count] = sb.toString();
            count++;
        }
        return result;

    }


    public String[] divideStringOptimal(String s, int k, char fill) {
        int n = s.length();
        int groups = (n + k - 1)/k;
        String[] result = new String[groups];
        for(int i=0;i<groups;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<k;j++){
                int idx = (i * k) + j;
                if(idx < n){
                    sb.append(s.charAt(idx));
                }else{
                    sb.append(fill);
                }
            }
            result[i] = sb.toString();
        }
        return result;
    }
}
