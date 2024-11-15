package com.coder.sanam;

import java.util.*;
import java.util.Map.Entry;

public class CheapestPriceAtKstops {
	
	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer,List<int[]>> adjMap = new HashMap<>();
        for(int [] flight:flights){
            adjMap.computeIfAbsent(flight[0], key -> new ArrayList<>()).add(new int[] {flight[1], flight[2]});
       }
       int[] costArr = new int[n];
       Arrays.fill(costArr, Integer.MAX_VALUE);
       int steps = 0;
       Queue<int[]> que = new LinkedList<int[]>();
       que.offer(new int[] {src,0});
       costArr[src] = 0;
       while(!que.isEmpty() && steps<=k) {
    	   int N = que.size();
    	   while(N!=0) {
    		   int[] poll = que.poll();
    		   int u = poll[0];
    		   int pollCost = poll[1];
    		   for(int[] adjList : adjMap.getOrDefault(u,new ArrayList<>())) {
    			   int v = adjList[0];
    			   int nCost = adjList[1] + pollCost;
    			   if(costArr[v] > nCost) {
    				   costArr[v] = nCost;
    				   que.offer(new int[] {v,nCost});
    			   }
    		   }
    		   N--;
    	   }
    	   steps++;
       }
        return costArr[dst] == Integer.MAX_VALUE? -1 : costArr[dst] ;
    }
	
	public static void main(String[] args) {
		int findCheapestPrice = findCheapestPrice(4, new int[][] {
			{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}
		}, 0, 3, 1);
		System.out.println(findCheapestPrice);
	}

}
