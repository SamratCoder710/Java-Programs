package com.coder.sanam;

public class DetectCyclesIn2DGrid {

    private int m;
    private int n;

    private final int[][] directions = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};

    public static void main(String[] args) {
        DetectCyclesIn2DGrid detectCyclesIn2DGrid = new DetectCyclesIn2DGrid();
        char[][] grid = new char[][]{{'a','a','a','a'},{'a','b','b','a'},{'a','b','b','a'},{'a','a','a','a'}};
        boolean result = detectCyclesIn2DGrid.containsCycle(grid);
        System.out.println(result);
    }

    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    if(checkCycle(i,j,-1,-1,grid,visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkCycle(int i, int j, int pi, int pj, char[][] grid,boolean[][] visited){
        visited[i][j] = true;

        for(int [] dir : directions){
            int ni = i + dir[0];
            int nj = j + dir[1];

            if(ni<0 || nj<0 || ni>=m ||nj>=n){
                continue;
            }

            if(grid[ni][nj] != grid[i][j]) continue;

            if(visited[ni][nj] && !(ni == pi && nj == pj)){
                return true;
            }

            if(!visited[ni][nj]){
                if(checkCycle(ni,nj,i,j,grid,visited)){
                    return true;
                }
            }

        }

        return false;
    }

}
