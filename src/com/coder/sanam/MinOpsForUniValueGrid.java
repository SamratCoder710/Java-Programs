package com.coder.sanam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinOpsForUniValueGrid {

    public static void main(String[] args) {
        MinOpsForUniValueGrid minOpsForUniValueGrid = new MinOpsForUniValueGrid();
        int result = minOpsForUniValueGrid.minOperations(new int[][]{{1, 2}, {3, 4}}, 1);
        System.out.println(result);
    }

    public int minOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();
        for(int [] row: grid){
            for(int ele : row){
                list.add(ele);
            }
        }

        // check divisibility
        int base = list.get(0);
        for(int v : list){
            if(Math.abs(v - base) % x != 0)
                return -1;
        }

        //sort
        Collections.sort(list);

        //median
        int target = list.get(list.size() / 2);

        //count ops
        int ops = 0;
        for(int ele : list){
            ops += Math.abs(target - ele)/ x;
        }
        return ops;

    }
}
