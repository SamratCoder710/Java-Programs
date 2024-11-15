package com.coder.sanam;

import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("23:59", "00:00");
        System.out.println(findMinDifference(list));
    }

    public static int findMinDifference(List<String> timePoints) {
        int min = Integer.MAX_VALUE;
        int n = timePoints.size();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            String[] s = timePoints.get(i).split(":");
            int value = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
            arr[i] = value;
        }
        Arrays.sort(arr);
        for(int i=0;i<n-1;i++){
            min = Math.min(min,arr[i+1]-arr[i]);
        }
        return Math.min(min,24*60 + arr[0] - arr[n-1]);
    }
}
