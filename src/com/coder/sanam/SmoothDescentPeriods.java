package com.coder.sanam;


public class SmoothDescentPeriods {

    public static void main(String[] args) {
        SmoothDescentPeriods obj = new SmoothDescentPeriods();
        int[] prices = {3,2,1,4};
        System.out.println(obj.getDescentPeriods(prices));
    }

    public long getDescentPeriods(int[] prices) {
        long result = 1;
        int n = prices.length;
        long val = 1;
        for(int i=1;i<n;i++){
            if(prices[i-1] - prices[i] == 1){
                val ++;

            }else{
                val = 1;
            }
            result += val;
        }
        return result;
    }
}
