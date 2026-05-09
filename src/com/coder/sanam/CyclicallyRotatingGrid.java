package com.coder.sanam;

import java.util.ArrayList;
import java.util.List;

public class CyclicallyRotatingGrid {

    public static void main(String[] args) {
        CyclicallyRotatingGrid cyclicallyRotatingGrid = new CyclicallyRotatingGrid();
        int[][] result = cyclicallyRotatingGrid.rotateGrid(new int[][]{{40, 10}, {30, 20}}, 1);
        for (int[] row : result) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }


    public int[][] rotateGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;
        int layers = Math.min(m / 2, n / 2);

        for (int layer = 0; layer < layers; layer++) {
            List<Integer> list = new ArrayList<>();
            int top = layer;
            int right = n - 1 - layer;
            int bottom = m - 1 - layer;
            int left = layer;

            // top row (left -> right)
            for (int j = left; j <= right; j++) {
                list.add(grid[top][j]);
            }

            // right row(top -> bottom)
            for (int j = top + 1; j <= bottom - 1; j++) {
                list.add(grid[j][right]);
            }

            // bottom row(right -> left)
            for (int j = right; j >= left; j--) {
                list.add(grid[bottom][j]);
            }

            // left row(bottom -> top)
            for (int j = bottom - 1; j >= top + 1; j--) {
                list.add(grid[j][left]);
            }

            int size = list.size();
            int index = k % size;

            for (int col = left; col <= right; col++) {
                grid[top][col] = list.get(index);
                index = (index + 1) % size;
            }

            for (int row = top + 1; row <= bottom - 1; row++) {
                grid[row][right] = list.get(index);
                index = (index + 1) % size;
            }

            for (int col = right; col >= left; col--) {
                grid[bottom][col] = list.get(index);
                index = (index + 1) % size;
            }

            for (int row = bottom - 1; row >= top + 1; row--) {
                grid[row][left] = list.get(index);
                index = (index + 1) % size;
            }
        }

        return grid;
    }

}
