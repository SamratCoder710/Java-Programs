package com.coder.sanam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PascalTriangleSolution {

    public static void main(String[] args) {
        PascalTriangleSolution pascalTriangleSolution = new PascalTriangleSolution();
        List<List<Integer>> generate = pascalTriangleSolution.generateAlternative(6);
        System.out.println(generate);
    }

    public List<List<Integer>> generate(int numRows) {
        int[][] result= new int[numRows][numRows];
        for(int i=0;i<numRows;i++){
            Arrays.fill(result[i],0,i+1,1);
            for(int j=1;j<i;j++){
                result[i][j] = result[i-1][j] + result[i-1][j-1];
            }
        }
        return Arrays.stream(result).map(row -> Arrays.stream(row).filter(x-> x!= 0).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList());
    }


    public List<List<Integer>> generateAlternative(int numRows) {
        List<List<Integer>> resultList = new ArrayList<>();
        if(numRows == 0) return resultList;

        List<Integer> list = new ArrayList<>();
        list.add(1);
        resultList.add(list);

        for(int i=1;i<numRows;i++){
            List<Integer> prevRow = resultList.get(i - 1);
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j=1;j<i;j++){
                row.add( prevRow.get(j) + prevRow.get(j - 1));
            }
            row.add(1);
            resultList.add(row);
        }
        return resultList;
    }
}
