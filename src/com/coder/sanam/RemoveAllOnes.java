package com.coder.sanam;

public class RemoveAllOnes {

    public static void main(String[] args) {
        RemoveAllOnes removeAllOnes = new RemoveAllOnes();
        boolean res = removeAllOnes.removeOnes(new int[][]{{0, 1, 0}, {1, 0, 1}, {0, 1, 0}});
        System.out.println(res);
    }

    public boolean removeOnes(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 1; i < m; i++) {
            boolean same = true;
            boolean inverse = true;

            for (int j = 0; j < n; j++) {
                if (grid[i][j] != grid[0][j]) {
                    same = false;
                }
                if (grid[i][j] == grid[0][j]) {
                    inverse = false;
                }
            }

            if (!same && !inverse) {
                return false;
            }
        }
        return true;
    }
}
