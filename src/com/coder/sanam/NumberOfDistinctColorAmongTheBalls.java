package com.coder.sanam;

import java.util.*;

public class NumberOfDistinctColorAmongTheBalls {

    public static void main(String[] args) {
        NumberOfDistinctColorAmongTheBalls numberOfDistinctColorAmongTheBalls = new NumberOfDistinctColorAmongTheBalls();
        int[] res = numberOfDistinctColorAmongTheBalls.queryResultsOpt(5, new int[][]{{0,1},{1,2},{2,2},{3,4},{4,5}});
        for (int re : res) {
            System.out.println(re);
        }
    }

    //TLE
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[queries.length];
        int idx = 0;
        for(int[] arr: queries){
            int ball = arr[0];
            int color = arr[1];
            map.put(ball, color);
            res[idx] = map.values().stream().distinct().toArray().length;
        }
        return res;
    }

    //Memory Limit Exceeded
    public int[] queryResultsMLE(int limit, int[][] queries) {
        int[] input = new int[limit+1];
        Arrays.fill(input,-1);
        int[] res = new int[queries.length];
        int idx = 0;
        for(int[] arr: queries){
            int ball = arr[0];
            int color = arr[1];
            input[ball] = color;
            res[idx] = Arrays.stream(input).filter(x -> x!= -1).distinct().toArray().length;
            idx++;
        }
        return res;
    }


    public int[] queryResultsOpt(int limit, int[][] queries) {
        Map<Integer, Integer> ballColor = new HashMap<>();
        Map<Integer, Integer> colorCount = new HashMap<>();
        int[] res = new int[queries.length];
        int idx = 0;
        for(int[] arr: queries){
            int ball = arr[0];
            int color = arr[1];
            if(ballColor.containsKey(ball)){
                int prevColor = ballColor.get(ball);
                colorCount.put(prevColor, colorCount.get(prevColor)-1);
                if(colorCount.get(prevColor) == 0){
                    colorCount.remove(prevColor);
                }
            }
            ballColor.put(ball, color);
            colorCount.put(color, colorCount.getOrDefault(color,0)+1);

            res[idx] = colorCount.size();
            idx++;
        }
        return res;
    }
}
