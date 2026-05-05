package com.coder.sanam;

public class RotateImageLeetcode {

    public static void main(String[] args) {
        RotateImageLeetcode rotateImageLeetcode = new RotateImageLeetcode();
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotateImageLeetcode.rotate(matrix);
        for(int[] row : matrix){
            for(int num : row){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        transpose(matrix);
        rowReverse(matrix);

    }

    private void rowReverse(int[][] mat) {
        for (int[] row : mat) {
            int i = 0;
            int j = row.length - 1;
            while (i < j) {
                int temp = row[i];
                row[i] = row[j];
                row[j] = temp;
                i++;
                j--;
            }
        }
    }

    private void transpose(int[][] mat) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i == j) {
                    continue;
                }

                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }


    }
}
