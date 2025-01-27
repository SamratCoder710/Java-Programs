package com.coder.sanam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduleIV {

    public static void main(String[] args) {
        CourseScheduleIV courseScheduleIV = new CourseScheduleIV();
        List<Boolean> booleans = courseScheduleIV.checkIfPrerequisite(2, new int[][]{{1, 0}}, new int[][]{{0, 1}, {1, 0}});
        System.out.println(booleans);

    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] arr : prerequisites) {
            int u = arr[0];
            int v = arr[1];
            List<Integer> orDefault = adjList.getOrDefault(u, new ArrayList<>());
            orDefault.add(v);
            adjList.put(u, orDefault);
        }

        for (int[] query : queries) {
            int u = query[0];
            int v = query[1];

            boolean[] visited = new boolean[numCourses];
            result.add(dfs(u, v, adjList, visited));
        }
        return result;
    }

    private boolean dfs(int u, int v, Map<Integer, List<Integer>> adjList, boolean[] visited) {
        if(u == v){
            return true;
        }
        visited[u] = true;
        boolean isReachable = false;
        if(adjList.containsKey(u)){
            for(int neighbour : adjList.get(u)){
                if(!visited[neighbour]){
                    isReachable = isReachable || dfs(neighbour,v,adjList,visited);
                }
            }
        }
        return isReachable;
    }

}

