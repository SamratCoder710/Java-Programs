package com.coder.sanam;

public class MagicSquareMedium {

    public static void main(String[] args) {
        MagicSquareMedium obj = new MagicSquareMedium();
        int[][] grid = {
                {4,3,8,4},
                {9,5,1,9},
                {2,7,6,2}
        };
        System.out.println(obj.numMagicSquaresInside(grid) );

    }

    public int numMagicSquaresInside(int[][] grid) {
        int row =  grid.length;
        int col = grid[0].length;
        int count =0;
        if(row < 3 || col < 3) return 0;
        for(int i=0;i<=row-3;i++){
            for(int j=0;j<=col-3;j++){
                if(isMagicSquare(grid,i,j)){
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isMagicSquare(int[][] grid, int r,int c){
        //check is num in range (0,9) and all distinct
        boolean[] seen = new boolean[10];
        for(int x= 0 ;x< 3;x++){
            for(int y=0;y<3;y++){
                int num = grid[r+x][c+y];
                if(num<1 || num >9 || seen[num]) return false;
                seen[num] = true;
            }
        }
        //check row , col, diagonal and antiDiagonal
        int sum = grid[r][c] + grid[r][c+1]+ grid[r][c+2];
        for(int i=0;i<3;i++){
            int cSum = grid[r][c+i] + grid[r+1][c+i] + grid[r+2][c+i];
            if(cSum != sum) return false;


            int rSum = grid[r+i][c] + grid[r+i][c+1] + grid[r+i][c+2];
            if(rSum != sum) return false;
        }

        int diagonalSum = grid[r][c]+grid[r+1][c+1]+grid[r+2][c+2];
        if(diagonalSum != sum) return false;

        int antiDiagonal = grid[r][c+2]+grid[r+1][c+1]+grid[r+2][c];
        if(antiDiagonal != sum) return false;

        return true;
    }

}
