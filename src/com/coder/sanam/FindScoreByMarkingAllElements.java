package com.coder.sanam;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindScoreByMarkingAllElements {

    public static void main(String[] args) {
        long score = findScoreOPtimized(new int[]{2, 1, 3, 4, 5, 2});
        System.out.println(score);
    }


    //TLE
    public static long findScore(int[] nums) {
        PriorityQueue<int[]> pq  = new PriorityQueue<>((a,b)->{
            if(a[0] != b[0]) {return Integer.compare(a[0],b[0]);}
            else {return Integer.compare(a[1],b[1]);}
        });

        for(int i=0;i< nums.length; i++){
            pq.add(new int[]{nums[i],i});
        }

        long sum = 0;
        while(!pq.isEmpty()){
            int[] peek = pq.peek();
            int ele = peek[0];
            int idx = peek[1];
            sum += ele;
            pq.removeIf(arr -> arr[0]== ele && arr[1] == idx);
            if(idx-1 >=0){
                pq.removeIf(arr -> arr[0]== nums[idx-1] && arr[1] == idx-1);
            }
            if(idx+1< nums.length){
                pq.removeIf(arr -> arr[0]== nums[idx+1] && arr[1] == idx+1);
            }

        }
        return  sum;
    }


    //
    public static long findScoreOPtimized(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];

        for(int i=0;i< nums.length; i++){
            dp[i][0] = nums[i];
            dp[i][1] = i;
        }

        Arrays.sort(dp,(a,b)-> a[0]-b[0]);
        long sum = 0;
        boolean[] marked = new boolean[n];
        for(int[] arr: dp){
            int ele = arr[0];
            int idx = arr[1];
            if(!marked[idx]){
                sum += ele;
                if(idx-1 >=0){
                   marked[idx-1] = true;
                }
                if(idx+1< nums.length){
                    marked[idx+1] = true;
                }
            }
        }
        return  sum;
    }
}
