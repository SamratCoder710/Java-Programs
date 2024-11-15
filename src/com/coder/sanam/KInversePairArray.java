package com.coder.sanam;

public class KInversePairArray {
	
	private static int MOD = 1000000000+7;
    private static int[][] t;
    public static int kInversePairs(int n, int k) {
        t = new int[1001][1001];
        for(int i=0;i<1001;i++){
            for(int j=0;j<1001;j++){
                t[i][j] = -1;
            }
        }
        return solve(n,k);
    }

    public static int solve(int n,int k){
        if(n == 0) return 0;

        if(k==0) return 1;

        if(t[n][k] != -1) return t[n][k];

        int result = 0;
        for(int inv=0;inv <= Math.min(k,n-1);inv++){
            result = (result % MOD + solve(n-1,k-inv) % MOD) % MOD;
        }
        return t[n][k] = result;
    }
    
    public static void main(String[] args) {
		int kInversePairs = kInversePairs(3, 1);
		System.out.println(kInversePairs);
	}

}
