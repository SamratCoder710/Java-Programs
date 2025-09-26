package com.coder.sanam;

import java.util.Arrays;
import java.util.List;

public class TriangleMinPath {

    public static void main(String[] args) {
        TriangleMinPath triangleMinPath = new TriangleMinPath();
        int i = triangleMinPath.minimumTotal(List.of(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        ));
        System.out.println(i);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        for(int idx=n-2;idx>=0;idx--){
            List<Integer> innerList = triangle.get(idx);
            for(int i=0;i<innerList.size();i++){
                int below = innerList.get(i) + triangle.get(idx + 1).get(i);
                int belowRight = innerList.get(i) + triangle.get(idx + 1).get(i+ 1);
                triangle.get(idx).set(i,Math.min(below, belowRight));
            }
        }
        return triangle.getFirst().getFirst();
    }

}

