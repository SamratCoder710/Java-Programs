package com.coder.sanam;

public class MinSwapsToArrangeBinaryGrid {

    public static void main(String[] args) {
        MinSwapsToArrangeBinaryGrid minSwapsToArrangeBinaryGrid = new MinSwapsToArrangeBinaryGrid();
        int[][] grid = {{0,0,1},{1,1,0},{1,0,0}};
        int res = minSwapsToArrangeBinaryGrid.minSwaps(grid);
        System.out.println(res);
    }

    private int minSwaps(int[][] grid) {
        int i = 0;
        int n = grid.length;
        int[] endZeroes = new int[n];
        for(int [] arr : grid){
            int idx = n-1;
            int count = 0;
            while(idx >=0 && arr[idx] == 0){
                idx--;
                count++;
            }

            endZeroes[i] = count;
            i++;
        }

        int steps = 0;
        for(int k=0;k<n;k++){
            int required = n - k -1;
            int j = k;
            while(j<n && endZeroes[j] <  required){
                j++;
            }
            if(j == n){
                return -1;
            }

            steps += j-k;
            swapRows(k,j,endZeroes);

        }
        return steps;
    }

    private void swapRows(int i, int j, int[] endZeroes) {
        while(j > i){
            int temp = endZeroes[j];
            endZeroes[j] = endZeroes[j-1];
            endZeroes[j-1] = temp;
            j--;
        }
    }


}
