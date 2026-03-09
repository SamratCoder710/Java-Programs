package com.coder.sanam;

public class FindAllPossibleStableBinaryArraysI {

    int M = 1000_000_007;
    Integer[][][] dp;

    public static void main(String[] args) {
        FindAllPossibleStableBinaryArraysI findAllPossibleStableBinaryArraysI = new FindAllPossibleStableBinaryArraysI();
        int res = findAllPossibleStableBinaryArraysI.numberOfStableArrays(3, 3, 2);
        System.out.println(res);
    }

    public int numberOfStableArrays(int zero, int one, int limit) {
        dp = new Integer[zero + 1][one + 1][2];
        int startWithZero = solve(zero,one,1,limit);
        int startWithOne = solve(zero,one,0,limit);
        return  (startWithZero + startWithOne) % M;
    }

    private int solve(int zeroesLeft, int onesLeft, int prevWasZero , int limit){
        if(zeroesLeft == 0 && onesLeft == 0){
            return 1;
        }
        if (dp[zeroesLeft][onesLeft][prevWasZero] != null) {
            return dp[zeroesLeft][onesLeft][prevWasZero];
        }

        int result = 0;
        if(prevWasZero == 1){
            for(int i=1;i<=Math.min(limit,onesLeft); i++){
                result = (result + solve(zeroesLeft,onesLeft - i,0,limit)) % M;
            }
        }else{
            for(int i=1;i<=Math.min(limit,zeroesLeft); i++){
                result = (result + solve(zeroesLeft - i,onesLeft,1,limit)) % M;
            }
        }
        return dp[zeroesLeft][onesLeft][prevWasZero] = result;
    }
}
