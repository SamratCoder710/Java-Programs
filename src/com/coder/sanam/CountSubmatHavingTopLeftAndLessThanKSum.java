package com.coder.sanam;

public class CountSubmatHavingTopLeftAndLessThanKSum {

    public static void main(String[] args) {
        CountSubmatHavingTopLeftAndLessThanKSum countSubmatHavingTopLeftAndLessThanKSum = new CountSubmatHavingTopLeftAndLessThanKSum();
        int res = countSubmatHavingTopLeftAndLessThanKSum.countSubmatrices(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 0}}, 4);
        System.out.println(res);
    }

    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n =  grid[0].length;
        int[][] temp = new int[m][n];
        int count = 0;
        //colSum
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                temp[i][j] = grid[i][j] + ((j>0)? temp[i][j-1] : 0);
            }
        }
        //rowSum
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                temp[i][j] = temp[i][j] + ((i>0)?temp[i-1][j]:0 ) ;
                if(temp[i][j] <= k){
                    count++;
                }
            }
        }


        return count;
    }
}
