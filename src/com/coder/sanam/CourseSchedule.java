package com.coder.sanam;

import java.util.*;

public class CourseSchedule {
	
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer,List<Integer>> adj = new HashMap<>();
        for(int[] pair:prerequisites) {
        	int v = pair[0];
        	int u = pair[1];
        	List<Integer> adjValue = adj.getOrDefault(u, new ArrayList<>());
        	adjValue.add(v);
        	adj.put(u, adjValue);
        	
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] inRecursion = new boolean[numCourses];
        for(int i=0;i<numCourses;i++) {
        	if(!visited[i] && isCycleDFS(adj,i,visited,inRecursion)) {
        		return false;
        	}
        }
        
        
        return true;
    }
	
	private static boolean isCycleDFS(Map<Integer, List<Integer>> adj, int u, boolean[] visited,
			boolean[] inRecursion) {
		visited[u] = true;
		inRecursion[u] = true;
		
		for(int v: adj.getOrDefault(u,new ArrayList<>())) {
			if(visited[v] == false && isCycleDFS(adj, v, visited, inRecursion)) {
				return true;
			}else if(inRecursion[v] == true) {
				return true;
			}
		}
		inRecursion[u] = false;
		return false;
	}

	public static void main(String[] args) {
		int[][] input = {
				{1,0}
		};
		boolean canFinish = canFinish(2, input);
		System.out.println(canFinish);
	}

}
