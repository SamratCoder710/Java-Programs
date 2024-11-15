package com.coder.sanam;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class MinimumPushesToTypeKey {

    public static void main(String[] args) {
        int sum = minimumPushes("cwokgnhaet");
        System.out.println(sum);
    }

    public static int minimumPushes(String word) {
        int[] arr = new int[26];
        for(char ch : word.toCharArray()){
            arr[ch-'a']++;
        }
        Arrays.sort(arr);
        int counter = 1;
        int multiplier = 1;
        int sum = 0;
        int i = arr.length -1;
        while (i>=0 && arr[i] >0) {
            sum += arr[i] * multiplier;
            if(counter % 8 == 0){
                multiplier += 1;
            }
            counter++;
            i--;
        }

        return sum;
    }
}
