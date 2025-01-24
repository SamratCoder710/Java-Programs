package com.coder.sanam;

import java.util.Arrays;

public class CountServerThatCommunicate {

    public static void main(String[] args) {
        CountServerThatCommunicate countServerThatCommunicate = new CountServerThatCommunicate();
        int i = countServerThatCommunicate.countServers(new int[][]{{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}});
        System.out.println(i);
    }

    //Brute Force
    public int countServersBruteForce(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int communicatingServers = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    boolean canCommunicate = false;
                    //check this ith row
                    for(int col=0;col<n;col++){
                        if(grid[i][col] == 1 && col!=j){
                            canCommunicate = true;
                            break;
                        }
                    }

                    if (!canCommunicate){
                        //then check this jth column
                        for(int row=0;row<m;row++){
                            if(grid[row][j] == 1 && row!=i){
                                canCommunicate = true;
                                break;
                            }
                        }
                    }

                    if (canCommunicate){
                        communicatingServers++;
                    }

                }
            }
        }
        return communicatingServers;
    }

    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] rowSum = new int[m];
        int[] colSum = new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    rowSum[i]++;
                    colSum[j]++;
                }
            }
        }
        int communicatingServers = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && (rowSum[i]>1 || colSum[j]>1)){
                    communicatingServers++;
                }
            }
        }
        return communicatingServers;
    }
}
