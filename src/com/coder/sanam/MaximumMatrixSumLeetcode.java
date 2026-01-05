package com.coder.sanam;

public class MaximumMatrixSumLeetcode {

    static void main(String[] args) {
        MaximumMatrixSumLeetcode obj = new MaximumMatrixSumLeetcode();
        int[][] matrix = {{-1,-1,-1},{-1,2,3}};
        System.out.println(obj.maxMatrixSum(matrix) ); // result should be 5
    }


    public long maxMatrixSum(int[][] matrix) {
        int n = matrix[0].length;
        long sum = 0;
        int min = Integer.MAX_VALUE;
        int neg = 0;
        for (int[] ints : matrix) {
            for (int j = 0; j < n; j++) {
                int val = Math.abs(ints[j]);
                sum += val;
                min = Math.min(min, val);
                if (ints[j] < 0) {
                    neg++;
                }
            }
        }

        if(neg % 2 == 0){
            //even
            return sum;
        }
        //odd
        return sum - 2L *(min);

    }

}
