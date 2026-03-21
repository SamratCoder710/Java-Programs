package com.coder.sanam;

public class FlipSubMatrixVertically {
    public static void main(String[] args) {
        FlipSubMatrixVertically flipSubMatrixVertically = new FlipSubMatrixVertically();
        // Input: grid = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]], x = 1, y = 0, k = 3
        int[][] res = flipSubMatrixVertically.reverseSubmatrix(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}, 1, 0, 3);

        // Input2 : grid = [[3,4,2,3],[2,3,4,2]], x = 0, y = 2, k = 2
        int[][] res2 = flipSubMatrixVertically.reverseSubmatrix(new int[][]{{3,4,2,3},{2,3,4,2}}, 0, 2, 2);
        for (int[] re : res2) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(re[j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for(int col=y;col<(y+k);col++){
            for(int row=0;row<k/2;row++){
                int r1 = x + row;
                int r2 = x + k - 1 - row;
                //swap grid[row][col], grid[z-row][col]
                int temp = grid[r1][col];
                grid[r1][col] = grid[r2][col];
                grid[r2][col] = temp;
            }
        }
        return grid;
    }
}
