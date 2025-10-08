package com.coder.sanam;

import java.util.Arrays;

public class SuccessfulPairOfSpellsAndPotions {

    public static void main(String[] args) {
        SuccessfulPairOfSpellsAndPotions successfulPairOfSpellsAndPotions = new SuccessfulPairOfSpellsAndPotions();
        int[] spells = {5, 1, 3};
        int[] potions = {1, 2, 3, 4, 5};
        long success = 7;
        int[] result = successfulPairOfSpellsAndPotions.successfulPairs(spells, potions, success);
        System.out.println(Arrays.toString(result));
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];
        Arrays.sort(potions);
        for(int i=0;i<n;i++){
            int target = (int) Math.ceil((double) success / (double) spells[i]);
            int idx = binarySearch(potions,target);
            if(idx == -1){
                result[i] = 0;
            }else{
                result[i] = m-idx;
            }

        }
        return result;
    }

    private int binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        int ans = -1;
        while(left<= right){
            int mid = left + (right -left)/2;
            if(arr[mid]>=target){
                //possible ans
                ans = mid;
                //check if lower is available
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }
}
