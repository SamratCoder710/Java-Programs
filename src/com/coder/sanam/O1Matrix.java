package com.coder.sanam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class O1Matrix {

    public static void main(String[] args) {
        O1Matrix o1Matrix = new O1Matrix();
        int[][] res = o1Matrix.updateMatrix(new int[][]{{0,0,0},{0,1,0},{1,1,1}});
        for (int[] re : res) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(re[j] + " ");
            }
            System.out.println();
        }
    }

        public int[][] updateMatrix(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            int[][] res = new int[m][n];
            int[][] directions = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
            for(int[] arr :res){
                Arrays.fill(arr,-1);
            }

            Queue<int[]> que = new ArrayDeque<>();
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(mat[i][j] == 0){
                        res[i][j] = 0;
                        que.add(new int[]{i,j});
                    }
                }
            }

            while(!que.isEmpty()){
                int[] front = que.poll();
                int i = front[0];
                int j = front[1];
                for(int[] dir: directions){
                    int new_i = i+ dir[0];
                    int new_j = j+dir[1];
                    if(new_i>= 0 && new_i<m && new_j <n && new_j >= 0 && res[new_i][new_j] == -1 ){
                        res[new_i][new_j] = res[i][j] + 1;
                        que.add(new int[]{new_i,new_j});
                    }
                }
            }

            return res;
        }

}
