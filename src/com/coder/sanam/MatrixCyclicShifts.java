package com.coder.sanam;

public class MatrixCyclicShifts {

    public static void main(String[] args) {
        MatrixCyclicShifts matrixCyclicShifts = new MatrixCyclicShifts();
        boolean res = matrixCyclicShifts.areSimilar(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1);
        System.out.println(res);
    }

    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        k = k%n;
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                // even indexed row
                if(r % 2 == 0){
                    // left rotate
                    // we don't want to use extra space so we are comparing the
                    // right k steps
                    if(mat[r][c] != mat[r][(c + k) % n]){
                        return false;
                    }
                }else{
                    // right rotate
                    // we don't want to use extra space so we are comparing the
                    // left k steps
                    if(mat[r][c] != mat[r][(c - k + n) % n]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
