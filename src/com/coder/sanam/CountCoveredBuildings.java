package com.coder.sanam;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountCoveredBuildings {


    public static void main(String[] args) {
        CountCoveredBuildings obj = new CountCoveredBuildings();
        //[1,2],[2,2],[3,2],[2,1],[2,3]
        int[][] buildings = { {1,2},{2,2},{3,2},{2,1},{2,3} };
        System.out.println(obj.countCoveredBuildings(3, buildings));
    }

    public int countCoveredBuildings(int n, int[][] buildings) {
        Arrays.sort(buildings,  (a, b)->a[1] == b[1] ? a[0]-b[0] : a[1]-b[1]);
        Set<String> xaligned = new HashSet<>();
        for( int i = 1; i < buildings.length-1; i++  ){
            if( buildings[i][1] == buildings[i-1][1] && buildings[i][1] == buildings[i+1][1]   ){
                xaligned.add(buildings[i][0]+","+buildings[i][1]);
            }
        }
        Arrays.sort(buildings,  (a,b)->a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
        int result = 0 ;
        for( int i = 1; i < buildings.length-1; i++  ){
            if( buildings[i][0] == buildings[i-1][0] && buildings[i][0] == buildings[i+1][0]   ){
                if( xaligned.contains(buildings[i][0]+","+buildings[i][1]) ) {
                    result++;
                }
            }
        }
        return result;
    }

}
