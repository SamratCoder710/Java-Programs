package sanam.arrays;

public class NumberOfClosedIslands {

    private int r;
    private int c;

    public static void main(String[] args) {
        NumberOfClosedIslands solution = new NumberOfClosedIslands();
        // grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
        
        int[][] grid1 = {
            {1, 1, 1, 1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0, 1, 1, 0},
            {1, 0, 1, 0, 1, 1, 1, 0},
            {1, 0, 0, 0, 0, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 0}
        };
        System.out.println(solution.closedIsland(grid1)); // Output: 2
        

        // grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
        int[][] grid2 = {
            {0, 0, 1, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 1, 1, 1, 0}
        };
        System.out.println(solution.closedIsland(grid2)); // Output: 1
    }

    private boolean dfs(int[][] grid, int row, int column){
        if(row<0 || column<0 || row>=r || column >=c){
            return false;
        }

        if(grid[row][column] == 1){
            return true;
        }

        grid[row][column] = 1; // mark visited

        boolean upClosed = dfs(grid,row - 1, column);
        boolean downClosed = dfs(grid,row + 1, column);
        boolean rightClosed = dfs(grid, row, column + 1);
        boolean leftClosed = dfs(grid, row, column - 1);

        return upClosed && downClosed && rightClosed && leftClosed;
    }
    
    public int closedIsland(int[][] grid) {
        r = grid.length;
        c = grid[0].length; 

        int count = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j] == 0){
                    if(dfs(grid,i,j)){
                        count++;
                    }
                }
            }
        }   
        return count;
    }
}
