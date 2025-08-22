package com.coder.sanam;

import java.util.Arrays;

public class CountSubmatricesWithAll1s {

    public static void main(String[] args) {
        CountSubmatricesWithAll1s countSubmatricesWithAll1s = new CountSubmatricesWithAll1s();
        int i = countSubmatricesWithAll1s.numSubmat(new int[][]{{1, 0, 1}, {1, 1, 0}, {1, 1, 0}});
        System.out.println(i);

    }

    public int numSubmat(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        int result = 0;
        for(int startRow =0; startRow < row ; startRow++){
            int[] arr = new int[col];
            Arrays.fill(arr,1);
            for(int endRow = startRow;endRow < row;endRow++){

                for(int column = 0;column<col;column++){
                    arr[column] = arr[column] & mat[endRow][column];
                }

                result += OneDArrayCount(arr);
            }
        }
        return result;
    }

    private int OneDArrayCount(int[] arr) {
        int sum =0;
        int consecutive1 = 0;
        for(int ele : arr){
            if(ele == 1){
                consecutive1++;
            }else{
                consecutive1 = 0;
            }
            sum += consecutive1;
        }

        return sum;
    }


}
