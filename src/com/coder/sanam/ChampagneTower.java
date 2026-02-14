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

    public double champagneTowerOptimal(int poured, int query_row, int query_glass) {
        double[][] tower = new double[102][102];
        tower[0][0] = (double) poured;

        for (int r = 0; r <= query_row; r++) {
            for (int c = 0; c <= r; c++) {
                if (tower[r][c] > 1.0) {
                    double excess = (tower[r][c] - 1.0) / 2.0;
                    tower[r][c] = 1.0;
                    tower[r + 1][c] += excess;
                    tower[r + 1][c + 1] += excess;
                }
            }
        }
        return tower[query_row][query_glass];
    }


}
