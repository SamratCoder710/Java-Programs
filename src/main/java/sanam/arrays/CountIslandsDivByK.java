package sanam.arrays;

public class CountIslandsDivByK{

    private int row;
    private int col;

    public static void main(String[] args) {
        CountIslandsDivByK obj = new CountIslandsDivByK();
        // Input: grid = [[0,2,1,0,0],[0,5,0,0,5],[0,0,1,0,0],[0,1,4,7,0],[0,2,0,0,8]], k = 5
        int[][] grid = {{0,2,1,0,0},{0,5,0,0,5},{0,0,1,0,0},{0,1,4,7,0},{0,2,0,0,8}};
        int k = 5;
        System.out.println(obj.countIslands(grid,k));
    }

    public int countIslands(int[][] grid, int k) {
        row =  grid.length;
        col = grid[0].length;

        int count = 0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] > 0 && dfsSum(grid,i,j) % k == 0){
                    count++;
                }
            }
        }    
        return count;
    }

    private int dfsSum(int[][] grid, int r, int c){ 
        if(r<0 || r>= row || c<0 || c>= col || grid[r][c] == 0){
            return 0;
        }
        int val = grid[r][c];
        grid[r][c] = 0;// mark visited
        int left = dfsSum(grid, r, c-1);
        int right = dfsSum(grid, r, c + 1);
        int up = dfsSum(grid, r-1, c);
        int down = dfsSum(grid, r+1, c);

        return val + left + right + up + down;
    }
}