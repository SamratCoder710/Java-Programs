package com.coder.sanam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinAbsDiff {


    public static void main(String[] args) {
        MinAbsDiff minAbsDiff = new MinAbsDiff();
        int[] arr = {4,2,1,3};
        System.out.println(minAbsDiff.minimumAbsDifference(arr));
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int n = arr.length;
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<n-1;i++){
            int diff = arr[i+1] - arr[i];
            if(min == diff){
                result.add(List.of(arr[i],arr[i+1]));
            }else if(diff < min){
                min = diff;
                result = new ArrayList<>();
                result.add(List.of(arr[i],arr[i+1]));
            }
        }
        return result;
    }
}
