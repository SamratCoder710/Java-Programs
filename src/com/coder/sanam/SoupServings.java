package com.coder.sanam;

public class SoupServings {

    public static void main(String[] args) {

        SoupServings soupServings = new SoupServings();
        double v = soupServings.soupServings(5000);
        System.out.println(v);
    }

    private int[][] array = {{100,0},{75,25},{50,50},{25,75}};

    private Double cache[][];
    public double soupServings(int n) {
        if(n > 5000) return 1;
        cache = new Double[n+1][n+1];
        return solve(n, n);
    }

    private double solve(int a,int b){
        if(a<=0 && b<=0) return 0.5;

        if(a <= 0) return 1;

        if(b<=0) return 0;

        if(cache[a][b] != null) return cache[a][b];

        double prob = 0.0;
        for(int[] arr: array){
            int a_removed = arr[0];
            int b_removed = arr[1];

            prob += solve(a-a_removed,b-b_removed);
        }

        return cache[a][b] = 0.25* prob;
    }


}
