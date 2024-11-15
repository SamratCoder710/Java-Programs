package com.coder.sanam;

public class RegionCutBySlashes {
    public static void main(String[] args) {
        int res = regionsBySlashes(new String[]{" /", "/ "});
        System.out.println(res);
    }

    public static int regionsBySlashes(String[] grid) {
        int inRows = grid.length;
        int inCols = grid[0].length();

        int[][] matrix = new int[inRows*3][inCols*3];
        for(int r=0; r<inRows;r++){
            for(int c=0;c<inCols;c++){
                if(grid[r].charAt(c) == '/'){
                    matrix[r*3][c*3+2] = 1;
                    matrix[r*3+1][c*3+1] = 1;
                    matrix[r*3+2][c*3]=1;
                }else if(grid[r].charAt(c) == '\\'){
                    matrix[r*3][c*3] = 1;
                    matrix[r*3+1][c*3+1] = 1;
                    matrix[r*3+2][c*3+2]=1;
                }
            }
        }
        int count =0;
        for(int row=0;row<matrix.length;row++){
            for(int col=0;col<matrix[0].length;col++){
                if(matrix[row][col] == 0){
                    dfs(matrix,row,col);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] matrix, int row, int col) {
        if(row<0 || row >= matrix.length || col<0 || col >= matrix[0].length || matrix[row][col] ==1 ){
            return;
        }
        matrix[row][col] = 1;
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int i=0;i<dir.length;i++){
            int newRow = row + dir[i][0];
            int newCol = col + dir[i][1];
            dfs(matrix,newRow,newCol);
        }
    }
}
