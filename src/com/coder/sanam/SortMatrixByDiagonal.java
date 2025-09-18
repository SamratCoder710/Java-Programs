package com.coder.sanam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SortMatrixByDiagonal {

    public static void main(String[] args) {
        SortMatrixByDiagonal obj = new SortMatrixByDiagonal();
        int[][] grid = {{1,7,3},
                        {9,8,2},
                        {4,5,6}};
        int[][] result = obj.sortMatrix(grid);
        for(int[] arr: result) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public int[][] sortMatrix(int[][] grid) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                List<Integer> lt = map.getOrDefault(i + j,new ArrayList<>());
                lt.add(grid[i][j]);
                map.put(i - j,lt);
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        for(int i=(Math.max(m,n) - 1) * (-1);i<= m+n-2;i++){
            List<Integer> result = map.get(i);
            list.add(result);
        }

        // Conversion
        int[][] arr = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            List<Integer> row = list.get(i);
            arr[i] = new int[row.size()];
            for (int j = 0; j < row.size(); j++) {
                arr[i][j] = row.get(j);
            }
        }
        return arr;
    }
}
