package com.coder.sanam;

public class MagicSquaresInGrid {

    public static void main(String[] args) {
        int[][] grid = {{4,3,8,4}, {9,5,1,9},{2,7,6,2}};
        int res = numMagicSquaresInside(grid);
        System.out.println(res);
    }

    public static int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count =0;
        for(int r=0;r<=rows-3;r++){
            for(int c=0;c<=cols-3;c++){
                if(isMagicSquare(grid,r,c)){
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isMagicSquare(int[][] grid, int r, int c) {

        boolean[] seen = new boolean[10];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                int num = grid[r + x][c + y];
                if (num < 1 || num > 9 || seen[num]) return false;
                seen[num] = true;
            }
        }
        int sum = grid[r][c] + grid[r][c+1] + grid[r][c+2];
        for(int i=0;i<3;i++){
            int rSum =  grid[r+i][c] + grid[r+i][c+1] + grid[r+i][c+2];
            if(rSum != sum) return false;

            int cSum =  grid[r][c+i] + grid[r+1][c+i] + grid[r+2][c+i];
            if(cSum != sum) return false;
        }
        int diagonalSum =  grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2];
        if(diagonalSum != sum) return false;

        int antiDiagonalSum =  grid[r][c+2] + grid[r+1][c+1] + grid[r+2][c];
        if(antiDiagonalSum != sum) return false;

        return true;
    }
}

