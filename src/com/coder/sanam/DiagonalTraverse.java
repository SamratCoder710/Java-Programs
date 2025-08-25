package com.coder.sanam;

import java.util.*;

public class DiagonalTraverse {

    public static void main(String[] args) {
        DiagonalTraverse diagonalTraverse = new DiagonalTraverse();
        int[] diagonalOrder = diagonalTraverse.findDiagonalOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        Arrays.stream(diagonalOrder).forEach(System.out::print);

    }

    public int[] findDiagonalOrder(int[][] mat) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                List<Integer> lt = map.getOrDefault(i+j, new ArrayList<>());
                lt.add(mat[i][j]);
                map.put(i+j,lt);
            }
        }
        boolean reverse = true;
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<= (m+n)-2 ;i++){
            if( !reverse){
                result.addAll(map.get(i));
            }else{
                result.addAll(map.get(i).reversed());
            }
            reverse = !reverse;

        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
