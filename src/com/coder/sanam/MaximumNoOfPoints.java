package com.coder.sanam;

public class MaximumNoOfPoints {

    public static void main(String[] args) {
        int[][] input = {{1,2,3},{1,5,1},{3,1,1}};

        long l = maxPoints(input);
        System.out.println(l);
    }

    public static long maxPoints(int[][] points) {
        int n = points[0].length;
        int m = points.length;
        long[] left = new long[n];
        long[] right = new long[n];
       for(int i=1;i<m;i++){
           int[] prevRow  = points[i-1];
           left[0] = prevRow[0];
           for(int k=1;k<n;k++){
               left[k] = Math.max(prevRow[k], left[k-1] - 1);
           }
           right[n-1] = prevRow[n-1];
           for(int k=n-2;k>=0;k--){
               right[k] = Math.max(prevRow[k], right[k+1] - 1);
           }
           for(int k=0;k<n;k++){
               points[i][k] += (int) Math.max(left[k],right[k]);
           }

       }
       long maxRes = Long.MIN_VALUE;
       for(int l=0;l<n;l++){
           maxRes = Math.max(maxRes,points[m-1][l]);
       }
       return maxRes;
    }
}
