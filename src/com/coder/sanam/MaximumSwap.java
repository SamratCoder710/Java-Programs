package com.coder.sanam;

import java.util.Arrays;

public class MaximumSwap {

    public static void main(String[] args) {
        int i = maximumSwap(2736);
        System.out.println(i);
    }

    public static int maximumSwap(int num) {
        String numberString = String.valueOf(num);
        char[] charArray = numberString.toCharArray();
        int n = charArray.length;
        char[] maxAtIArray = new char[n];
        maxAtIArray[n-1] = charArray[n-1];
        for(int i= n-2;i>=0;i--){
            char ch  = charArray[i];
            if(maxAtIArray[i+1] < ch){
                maxAtIArray[i] = ch;
            }else{
                maxAtIArray[i] = maxAtIArray[i+1];
            }
        }

        for(int i =0;i<n;i++){
            if(maxAtIArray[i] > charArray[i]){
                int max = maxAtIArray[i];
                int j = i;
                while(maxAtIArray[j+1] == max){
                    j++;
                }
                char temp = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = temp;
                break;
            }
        }

        return Integer.parseInt(new String(charArray));
    }
}
