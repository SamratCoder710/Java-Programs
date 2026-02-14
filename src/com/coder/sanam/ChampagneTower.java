package com.coder.sanam;

public class ChampagneTower {

    int pouredCup;
    double[][] dp = new double[100][100];

    public static void main(String[] args) {
        ChampagneTower champagneTower = new ChampagneTower();
        double i = champagneTower.champagneTower(2, 1, 1);
        System.out.println(i);
    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        pouredCup = poured;
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                dp[i][j] = -1;
            }
        }
        return Math.min(0.0,solve(query_row,query_glass));
    }

    private double solve(int i, int j) {
        if((i<0) || (j<0) || (i<j)){
            return 0;
        }

        if(i == 0 && j == 0){
            return pouredCup;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        double leftUp = (solve(i-1, j-1) - 1)/2.0;
        double rightUp = (solve(i-1, j) - 1)/2.0;

        if(leftUp < 0){
            leftUp = 0;
        }
        if(rightUp < 0){
            rightUp = 0;
        }

        return dp[i][j] = leftUp + rightUp;
    }


}
