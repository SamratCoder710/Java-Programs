package com.coder.sanam;

import java.util.PriorityQueue;

public class MaximumAveragePassRatio {

    public static void main(String[] args) {
        double v = maxAverageRatio(new int[][]{{1, 2}, {3, 5}, {2, 2}}, 2);
        System.out.println(v);
    }

    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b)-> {
            return Double.compare(b[0], a[0]);
        });
        for(int i=0;i<n;i++){
            heapPush(pq,classes,i);
        }
        while(extraStudents>0){
            double[] peek = pq.poll();
            int idx = (int) peek[1];
            classes[idx][0]++;
            classes[idx][1]++;
            heapPush(pq,classes,idx);
            extraStudents--;
        }
        double finalAvg = 0.0;
        for (int[] aClass : classes) {
            finalAvg += (double) aClass[0] / aClass[1];
        }

        return finalAvg/n;
    }

    private static void heapPush(PriorityQueue<double[]> pq, int[][] classes, int i) {
        double currAvg = (double) classes[i][0] /classes[i][1];
        double oneExtraAvg = (double) (classes[i][0] + 1) /(classes[i][1] + 1);
        double possibleIncrement = oneExtraAvg - currAvg;
        pq.add(new double[]{possibleIncrement,i});
    }


}
