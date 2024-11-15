package com.coder.sanam;

public class BuyAndSellStocks {
	
	public static int maxProfitOptimized(int[] prices) {
        int min  = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for(int i=0;i<prices.length-1;i++){
            min = Math.min(min,prices[i]);
            maxProfit = Math.max(maxProfit,prices[i] - min );
        }
        return maxProfit ;
    }

	public static int maxProfitBruteForce(int[] prices) {
        int largest  = 0;
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                if(prices[i]< prices[j]){
                    largest = Math.max(largest,prices[j]-prices[i]);
                }
            }
        }
        return largest ;
    }
	
	public static void main(String[] args) {
		int maxProfit = maxProfitOptimized(new int[] {7,1,5,3,6,4});
		System.out.println(maxProfit);
	}
	
	
}
