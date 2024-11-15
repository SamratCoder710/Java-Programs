package com.coder.sanam;

import java.util.*;

public class CourseScheduleII {
	
	private static boolean hasCycle;
	
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		Map<Integer,List<Integer>> adj = new HashMap<>();
		int[] res = new int[numCourses];
        for(int[] pair:prerequisites) {
        	int v = pair[0];
        	int u = pair[1];
        	List<Integer> adjValue = adj.getOrDefault(u,new ArrayList<>());
        	adjValue.add(v);
        	adj.put(u, adjValue);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] inRecursion = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();
        hasCycle = false;
        
        for(int i=0;i<numCourses;i++) {
        	if(!visited[i]) {
        		dfs(adj,i,visited,stack,inRecursion);
        	}
        }
        
        
        if(hasCycle == true) {
        	return new int[] {};
        }
        int counter = 0;
        while(!stack.isEmpty()) {
        	Integer top = stack.peek();
        	res[counter] = top;
        	counter++;
        	stack.pop();
        }
		return res;
    }
	
	
	private static void dfs(Map<Integer, List<Integer>> adj, int u, boolean[] visited, Stack<Integer> stack,boolean[] inRecursion) {
		 
		 visited[u] = true;
		 inRecursion[u] = true;
		 
		 for(int v:adj.getOrDefault(u, new ArrayList<>())) {
			 if(inRecursion[v] == true) {
				 hasCycle = true;
				 return;
			 }
			 if(!visited[v]) {
				 dfs(adj,v,visited,stack,inRecursion);
			 } 
		 }
		 
		 stack.push(u);
		 inRecursion[u] = false;
	}
	
	


	public static void main(String[] args) {
		int[][] input = {
//				{1,0},{2,0}
//				,{3,1},{3,2}	
		};
		int[] findOrder = findOrder(2, input);
		System.out.print("::");
		for(int x:findOrder) {
			System.out.print(x+"::");
		}
	}
	
	
}
