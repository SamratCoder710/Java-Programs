package com.coder.sanam;

import java.util.Arrays;

public class MinCostOfBuyingCandiesWithDiscount {

    public static void main(String[] args) {
        MinCostOfBuyingCandiesWithDiscount minCostOfBuyingCandiesWithDiscount = new MinCostOfBuyingCandiesWithDiscount();
        int[] cost = {1,2,3};
        int result = minCostOfBuyingCandiesWithDiscount.minimumCost(cost);
        System.out.println(result);
    }

    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int val = 0;

        for(int i=cost.length-1; i>=0; i-=3){
            val += cost[i];
            if(i - 1 >= 0) val += cost[i-1];
        }
        return val;
    }
}
