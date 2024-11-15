package com.coder.sanam;

import java.util.List;

public class MaximumDistanceInArrays {

    public static void main(String[] args) {
        int i = maxDistance(List.of(List.of(1, 2, 3), List.of(4, 5), List.of(1, 2, 3)));
        System.out.println(i);
    }

    public static int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size()-1);
        int res = 0;
        for(int i=1; i<arrays.size();i++ ){
            List<Integer> li = arrays.get(i);
            int currMin = li.get(0);
            int currMax = li.get(li.size()-1);

            res = Math.max(Math.max(res,Math.abs(currMax - min)),Math.abs(max - currMin));
            min = Math.min(min,currMin);
            max = Math.max(max,currMax);

        }
        return res;
    }
}
