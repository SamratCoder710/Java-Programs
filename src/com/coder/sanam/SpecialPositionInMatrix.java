package com.coder.sanam;

public class SpecialPositionInMatrix {

    public static void main(String[] args) {
        SpecialPositionInMatrix specialPositionInMatrix = new SpecialPositionInMatrix();
        int i = specialPositionInMatrix.numSpecial(new int[][]{{1, 0, 0}, {0, 0, 1}, {1, 0, 0}});
        System.out.println(i);
    }

    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] countRow = new int[m];
        int[] countCol = new int[n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 1){
                    countRow[i]++;
                    countCol[j]++;
                }
            }
        }

        int result = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 1 && countRow[i] == 1 && countCol[j] == 1){
                    result++;
                }
            }
        }

        return result;
    }
}
