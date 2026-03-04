package com.coder.sanam;

import java.util.HashMap;
import java.util.Map;

public class FirstCompletelyPainterRowOrColumn {

    public static void main(String[] args) {
        FirstCompletelyPainterRowOrColumn firstCompletelyPainterRowOrColumn = new FirstCompletelyPainterRowOrColumn();
        int i = firstCompletelyPainterRowOrColumn.firstCompleteIndex(new int[]{1, 3, 4, 2}, new int[][]{{3, 4, 1, 2}, {4, 1, 2, 3}, {1, 2, 3, 4}, {2, 3, 4, 1}});
        System.out.println(i);
    }


        public int firstCompleteIndex(int[] arr, int[][] mat) {
            Map<Integer,int[]> mp = new HashMap<>();
            int m = mat.length;
            int n = mat[0].length;

            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    int key = mat[i][j];
                    mp.put(key,new int[]{i,j});
                }
            }

            int[] row = new int[m];
            int[] col = new int[n];
            for(int idx=0; idx<arr.length;idx++){
                int[] value = mp.get(arr[idx]);
                row[value[0]]++;
                col[value[1]]++;

                if(row[value[0]] == n || col[value[1]] == m){
                    return idx;
                }
            }

            return -1;
        }
}

