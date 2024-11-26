package com.coder.sanam;

public class FindChampionII {

    public static void main(String[] args) {
        int champion = findChampion(2, new int[][]{{1,0}});
        System.out.println(champion);
    }

    public static int findChampion(int n, int[][] edges) {
        int[] res = new int[n];
        for(int[] arr: edges){
//            U is never used so commenting..
//            int u = arr[0];
            int v = arr[1];

            //Indegree of V points
            res[v]++;
        }
        int count = 0;
        int champ = -1;
        for(int i =0;i<res.length; i++){
            if(res[i] ==0){
                count++;
                champ = i;
            }
            if(count >1){
                return -1;
            }
        }
        return champ;

    }
}
