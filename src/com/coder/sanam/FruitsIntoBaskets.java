package com.coder.sanam;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets {

    public static void main(String[] args) {
        FruitsIntoBaskets fruitsIntoBaskets = new FruitsIntoBaskets();
        int i = fruitsIntoBaskets.totalFruit(new int[]{4,1,1,1,3,1,7,5});
        System.out.println(i);
    }

    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer,Integer> freq = new HashMap<>();
        int count = 0;
        int result = 0;
        int i = 0;
        for(int j=0;j<n;j++){
            freq.put(fruits[j],freq.getOrDefault(fruits[j],0)+ 1);
            count++;
            while(freq.size() > 2){
                int initialCount = count;
                int k = fruits[i];
                while(fruits[i] == k){
                    i++;
                    count--;
                }
                int newValue = freq.get(k) - (initialCount - count);
                if(newValue == 0){
                    freq.remove(k);
                }else{
                    freq.put(k,newValue);
                }


            }

            result = Math.max(result,count );

        }
        return result;
    }


    public int totalFruitOptimal(int[] fruits) {
        int n = fruits.length;
        Map<Integer,Integer> freq = new HashMap<>();
        int maxLen = 0;
        int i = 0;
        for(int j=0;j<n;j++){
            freq.put(fruits[j],freq.getOrDefault(fruits[j],0)+ 1);
            while(freq.size() > 2){
                freq.put(fruits[i],freq.get(fruits[i])- 1);
                if(freq.get(fruits[i]) == 0){
                    freq.remove(fruits[i]);
                }
                i++;
            }

            maxLen = Math.max(maxLen, j-i+1);

        }
        return maxLen;
    }
}
