package com.coder.sanam;

import java.util.PriorityQueue;
import java.util.TreeSet;

public class MinimumAreaToCoverAll1s {

    public static void main(String[] args) {
        MinimumAreaToCoverAll1s minimumAreaToCoverAll1s = new MinimumAreaToCoverAll1s();
        int i = minimumAreaToCoverAll1s.minimumAreaTree(new int[][]{{0, 1, 0}, {1, 0, 1}});
        System.out.println(i);
    }

    public int minimumArea(int[][] grid) {
        int minRow = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE;
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;

        int[] arr = new int[]{minRow,maxRow,minCol,maxCol};
        int rowCount = grid.length;
        int colCount = grid[0].length;

        for(int row= 0;row < rowCount;row++) {
            for(int col =0;col<colCount;col++) {
                if(grid[row][col] == 1){
                    arr = updateMaxMin(row, col, arr);
                }
            }
        }


        return (arr[1] - arr[0] + 1)*(arr[3] - arr[2] +1);
    }

    private int[] updateMaxMin(int row, int col, int[] arr) {
        int minRow = arr[0];
        int maxRow = arr[1];
        int minCol = arr[2];
        int maxCol = arr[3];

        if(row < minRow) minRow = row;
        if(row > maxRow) maxRow = row;
        if(col < minCol) minCol = col;
        if(col > maxCol) maxCol = col;

        return new int[]{minRow,maxRow,minCol,maxCol};
    }


    public int minimumAreaTree(int[][] grid) {
        TreeSet<Integer> rowQueue = new TreeSet<>();
        TreeSet<Integer> colQueue = new TreeSet<>();
        int rowCount = grid.length;
        int colCount = grid[0].length;

        for(int row= 0;row < rowCount;row++) {
            for(int col =0;col<colCount;col++) {
                if(grid[row][col] == 1){
                    rowQueue.add(row);
                    colQueue.add(col);
                }
            }
        }

        return (rowQueue.last() -rowQueue.first() + 1) *(colQueue.last() -colQueue.first() + 1);

    }


}
