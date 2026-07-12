package com.coder.sanam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class RankTransformOfArray {

    public static void main(String[] args) {
        int[] arr = {40, 10, 20, 30};
        int[] result = new RankTransformOfArray().arrayRankTransform(arr);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public int[] arrayRankTransform(int[] arr) {
        int[] copyArr = arr.clone();
        Arrays.sort(copyArr);
        int rank = 1;
        int n = copyArr.length;
        if(n==0) return new int[]{};
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(copyArr[0],rank);
        for(int i =1;i<n;i++){
            if(copyArr[i] > copyArr[i-1]){
                rank++;
            }
            mp.put(copyArr[i],rank);
        }
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            result[i] = mp.get(arr[i]);
        }   
        return result;

    }
}