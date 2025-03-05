package com.coder.sanam;

public class CountNumberOfColoredCells {

    public static void main(String[] args) {
        CountNumberOfColoredCells countNumberOfColoredCells = new CountNumberOfColoredCells();
        long l = countNumberOfColoredCells.coloredCellsOptimized(4);
        System.out.println(l);
    }

    public long coloredCells(int n) {
        long[] coloredCells = new long[n+1];
        coloredCells[1] = 1;
        for(int i=2;i<=n;i++){
            coloredCells[i] = 2 + (2L * oddNumber(i-1)+ coloredCells[i-1]);
        }
        return coloredCells[n];
    }

    private int oddNumber(int i) {
        return 2*i-1;
    }

    public long coloredCellsOptimized(int n) {
        long sum = 1;
        for(int i=2;i<=n;i++){
            sum += (i-1)*4; //4 times the previous level
        }
        return sum;
    }
}

