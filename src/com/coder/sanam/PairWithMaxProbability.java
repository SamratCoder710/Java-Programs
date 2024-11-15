package com.coder.sanam;

import java.util.*;

public class PairWithMaxProbability {

    public static void main(String[] args) {
        double v = maxProbability(500, new int[][]{{193,229},{133,212},{224,465}}, new double[]{0.91,0.78,0.64}, 4, 364);
        System.out.println(v);
    }

    static class Pair{
        int node;
        double prob;
        Pair( double p,int n ){
            this.node = n;
            this.prob = p;
        }
    }

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Pair>> adj = new HashMap<>();
        double[] result = new double[n];
        result[start_node] = 1;

        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];

            List<Pair> orDefault = adj.getOrDefault(u, new ArrayList<>());
            orDefault.add(new Pair(succProb[i],v));
            adj.put(u,orDefault);

            List<Pair> prDefault = adj.getOrDefault(v, new ArrayList<>());
            prDefault.add(new Pair(succProb[i],u));
            adj.put(v,prDefault);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Double.compare(b.prob,a.prob));
        pq.add(new Pair(1.0,start_node));

        while(!pq.isEmpty()){

            Pair pair = pq.peek();
            int currNode = pair.node;
            double currProb = pair.prob;
            pq.poll();
            for(Pair d: adj.getOrDefault(currNode,new ArrayList<>())){
                int adjNode = d.node;
                double adjProb = d.prob;
                if(adjProb * currProb > result[adjNode]){
                    result[adjNode] = adjProb * currProb;
                    pq.add(new Pair(result[adjNode],adjNode));
                }
            }
        }
        return result[end_node];
    }
}
