package com.coder.sanam;

public class MaximizeIceCreamBars {

    static void main() {
        MaximizeIceCreamBars maximizeIceCreamBars = new MaximizeIceCreamBars();
        int[] costs = {1, 3, 2, 4, 1};
        int coins = 7;
        int result = maximizeIceCreamBars.maxIceCream(costs, coins);
        System.out.println(result); // Output: 4
    }

    public int maxIceCream(int[] costs, int coins) {
        int maxCost = 0;
        for(int cost : costs){
            maxCost = Math.max(maxCost, cost);
        }

        int[] freq = new int[maxCost + 1];
        for(int cost : costs){
            freq[cost]++;
        }
        int res = 0;
        for(int cost=1;cost<= maxCost && cost<= coins;cost++){
            if(freq[cost] == 0) continue;

            int canBuy = Math.min(freq[cost], coins/cost);
            res += canBuy;
            coins -= canBuy * cost;

        }
        return res;
    }
}
