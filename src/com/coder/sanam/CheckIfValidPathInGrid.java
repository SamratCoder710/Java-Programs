package com.coder.sanam;

public class CheckIfValidPathInGrid {


    public static void main(String[] args) {
        CheckIfValidPathInGrid checkIfValidPathInGrid = new CheckIfValidPathInGrid();
        //[[2,4,3],[6,5,2]]
        boolean result = checkIfValidPathInGrid.hasValidPath(new int[][]{{2,4,3},{6,5,2}});
        System.out.println(result);
    }

    private int m;
    private int n;

    private final int[][][] directions = {
            {{},{}},
            {{0,1},{0,-1}}, //1
            {{1,0},{-1,0}}, //2
            {{0,-1},{1,0}}, //3
            {{0,1},{1,0}}, //4
            {{0,-1},{-1,0}}, //5
            {{0,1},{-1,0}}  //6
    };

    public boolean hasValidPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        //start at (i,j)
        return solve(grid,visited,0,0);
    }

    private boolean solve(int[][] grid, boolean[][] visited, int i, int j){
        //arrived at bottom right
        if(i == m-1 && j == n-1){
            return true;
        }

        visited[i][j] = true;

        for(int[] direction : directions[grid[i][j]]){
            int new_i = i + direction[0];
            int new_j = j + direction[1];
            if(new_i<0 || new_i>= m || new_j<0 || new_j>= n || visited[new_i][new_j]){
                continue;
            }

            //check back path if valid proceed with next call
            for(int[] backDir : directions[grid[new_i][new_j]]){
                int back_i = new_i + backDir[0];
                int back_j = new_j + backDir[1];
                if(back_i == i && back_j == j){
                    if(solve(grid, visited, new_i, new_j)){
                        return true;
                    }
                }
            }

        }

        return false;
    }

}
