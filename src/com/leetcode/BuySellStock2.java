package com.leetcode;


// Greedy approach
public class BuySellStock2 {
	public int maxProfit(int[] prices) {
		if(prices.length <= 1) return 0;
		
        int maxProfit = 0;
        
        for(int i = 1; i < prices.length; i++) {
        	if(prices[i] > prices[i-1]) {
            	maxProfit += prices[i] - prices[i-1];
        	}
        }
        return maxProfit;
    }
	
	public static void main(String a[]) {
		BuySellStock2 ob = new BuySellStock2();
		
//		int[] prices = {7,1,5,3,6,4};
		int[] prices = {1,2,3,4,5};
		
		System.out.println(ob.maxProfit(prices));
	}
}
