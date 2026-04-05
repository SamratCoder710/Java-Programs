package com.coder.sanam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfProvinces {

    public static void main(String[] args) {
        NumberOfProvinces numberOfProvinces = new NumberOfProvinces();
        int result = numberOfProvinces.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
        System.out.println(result);
    }

    public int findCircleNumOptimal(int [][] isConnected){
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,visited,isConnected);
                count++;
            }
        }

        return count;
    }

    private void dfs(int idx,boolean[] visited, int[][] isConnected) {
        visited[idx] = true;
        for(int j=0;j<isConnected.length;j++){
            if(isConnected[idx][j] == 1 && !visited[j]){
                dfs(j, visited, isConnected);
            }
        }
    }


    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;

                if(isConnected[i][j] ==1){
                    List<Integer> elem = adj.getOrDefault(i,new ArrayList<>());
                    elem.add(j);
                    adj.put(i,elem);
                }
            }
        }

        System.out.println(adj);
        int count = 0;
        boolean[] covered = new boolean[n];
        for(int i=0;i<n;i++){
            if(!covered[i]){
                coverAllMembers(i, covered,adj);
                count++;
            }
        }

        return count;
    }

    private void coverAllMembers(int idx, boolean[] covered, Map<Integer, List<Integer>> adj){
        covered[idx] = true;
        for(int neighbour: adj.getOrDefault(idx, new ArrayList<>())){
            if(!covered[neighbour]){
                coverAllMembers(neighbour, covered, adj);
            }
        }
    }


}
