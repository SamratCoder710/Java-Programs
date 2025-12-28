package com.coder.sanam;

public class CountNegativeNumInSortedMatrix {

    public static void main(String[] args) {
        CountNegativeNumInSortedMatrix obj = new CountNegativeNumInSortedMatrix();
        int[][] grid = {
                {4,3,2,-1},
                {3,2,1,-1},
                {1,1,-1,-2},
                {-1,-1,-2,-3}
        };
//        System.out.println(obj.countNegatives(grid));

        // [[3,2],[1,0]]
        int[][] grid2 = {
                {3,2},
                {1,0}
        };
        System.out.println(obj.countNegatives(grid2));
    }

    public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int result = 0;
        for(int col =0;col <cols;col++){
            result += binarySearch(col,grid,rows);
        }
        return result;
    }

    private int binarySearch(int col ,int[][] grid,int rows){
        int l = 0;
        int r= rows - 1;
        int firstNegRow = -1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(grid[mid][col] < 0){
                firstNegRow = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return firstNegRow == -1 ? 0 : rows - firstNegRow;
    }


}
