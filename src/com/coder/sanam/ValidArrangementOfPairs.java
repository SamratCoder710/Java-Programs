package com.coder.sanam;

import java.util.*;

public class ValidArrangementOfPairs {

    public static void main(String[] args) {
        int[][] ints = validArrangement(new int[][]{{8,5},{8,7},{0,8},{0,5},{7,0},{5,0},{0,7},{8,0},{7,8}});
        for(int[] i :ints){
            System.out.println("Pair ["+i[0]+ ","+i[1]+"]");
        }
    }


    public static int[][] validArrangement(int[][] pairs) {
        Map<Integer, List<Integer>> graph=new HashMap();
        Map<Integer, Integer> node=new HashMap();

        for(int[] pair:pairs){
            if(!graph.containsKey(pair[0])){
                graph.put(pair[0], new ArrayList());
            }
            graph.get(pair[0]).add(pair[1]);    //Preparing graph
            node.put(pair[0], node.getOrDefault(pair[0],0)-1); //Outgoing
            node.put(pair[1], node.getOrDefault(pair[1],0)+1); //Incoming
        }


        //selecting the starting node
        int startNode=pairs[0][0];
        for(Map.Entry<Integer, Integer> enty:node.entrySet()){
            if(enty.getValue()==-1){
                startNode=enty.getKey();
                break;
            }
        }

        List<Integer> circuit = new ArrayList();
        dfs(graph, startNode,circuit);
        Collections.reverse(circuit);


        int[][] result=new int[pairs.length][2];
        for(int i=1; i<circuit.size(); i++){
            result[i-1][0]=circuit.get(i-1);
            result[i-1][1]=circuit.get(i);
        }

        return result;
    }

    static void dfs(Map<Integer, List<Integer>> graph, int u, List<Integer> circuit){
        while(graph.containsKey(u) && !graph.get(u).isEmpty()){
            int v=graph.get(u).remove(0);
            dfs(graph, v, circuit);
        }
        circuit.add(u);
    }
}
