package com.coder.sanam;

public class MaxAreaOfIsland {

    private int row;
    private int col;
    private final int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

    public static void main(String[] args) {
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int res = maxAreaOfIsland.maxAreaOfIsland(grid);
        System.out.println(res);
    }

    public int maxAreaOfIsland(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        int area = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 1){
                    area = Math.max(area,dfs(i,j,grid));
                }
            }
        }
        return area;
    }

    private int dfs(int r,int c,int[][] grid){
        if(r<0 || c < 0 || r>= row || c >= col || grid[r][c] == 0){
            return 0;
        }
        grid[r][c] = 0;
        int sum = 0;
        for(int[] d: dir ){
            int r_ = r + d[0];
            int c_ = c + d[1];
            sum += dfs(r_,c_,grid);
        }
        return 1 + sum;

    }
}
