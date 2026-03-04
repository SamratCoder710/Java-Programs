package com.coder.sanam;

public class DiffBetOnesAndZeroes {

    public static void main(String[] args) {
        DiffBetOnesAndZeroes diffBetOnesAndZeroes = new DiffBetOnesAndZeroes();
        int[][] res = diffBetOnesAndZeroes.onesMinusZeros(new int[][]{{0,1,1},{1,0,1},{0,0,1}});
        for (int[] re : res) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(re[j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] onesRow = new int[m];
        int[] onesCol = new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    onesRow[i]++;
                    onesCol[j]++;
                }
            }
        }
        int [][] diff = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                diff[i][j] = onesRow[i] + onesCol[j] - (m - onesRow[i]) - (n - onesCol[j]);
            }
        }
        return diff;


    }
}
