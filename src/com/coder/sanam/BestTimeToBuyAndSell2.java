package com.coder.sanam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class BestTimeToBuyAndSell2 {
	public static int maxProfit(int[] prices) {
        int priceLen = prices.length;
        int output =0;
        for(int i=0;i<priceLen-1;i++){
                if(prices[i+1] >prices[i]){
                    output += prices[i+1]-prices[i];
                }
        }
        return output;
        
    }
	
	public static void main(String[] args) {
		int maxProfit = maxProfit(new int[] {7,1,5,3,6,4});
		System.out.println(maxProfit);
	}
}
