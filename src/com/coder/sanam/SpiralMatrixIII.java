package com.coder.sanam;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixIII {

    public static void main(String[] args) {
        int[][] ints = spiralMatrixIII(1, 4, 0, 0);
        for(int[] i :ints){
            for(int j: i){
                System.out.print(j+",");
            }
            System.out.println();
        }
    }

    public static int[][] convertListToArray(List<int[]> list) {
        // Create a new int[][] with the same number of rows as the list size
        int[][] array = new int[list.size()][];

        // Copy each int[] from the list to the int[][]
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }

        return array;
    }

    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        int totalCells = rows*cols;
        int steps = 0;
        int dir = 0;
        List<int[]> result = new ArrayList<>();
        result.add(new int[]{rStart,cStart});
        while(result.size() != totalCells){
            if(dir == 0 || dir == 2){
                steps++;
            }
            for(int count = 0;count<steps;count++){
                rStart += directions[dir][0];
                cStart += directions[dir][1];

                if(rStart>= 0 && rStart < rows && cStart>=0 && cStart < cols){
                    result.add(new int[]{rStart,cStart});
                }
            }
            dir = (dir + 1) % 4;
        }
        return convertListToArray(result);
    }
}
