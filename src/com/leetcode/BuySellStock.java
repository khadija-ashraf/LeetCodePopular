package com.leetcode;

public class BuySellStock {

	public int maxProfit(int[] prices) {
		if(prices.length <= 0) return 0;
		
        int maxProfit = Integer.MIN_VALUE;
        int minPrice = prices[0];
        
        for(int i = 0; i < prices.length; i++) {
        	// the day we find the lowest price we can not sell that day, 
        	// so there is no point of comparing the profit, so in a single day 
        	// either we find the lowest price, if we don't find a lower buying price 
        	// then we try selling, and compare max profit. 
        	if(prices[i] < minPrice) {
            	minPrice = prices[i]; 	 // this is the buying day
        	} else {
        		// this is the selling day
            	maxProfit = Math.max(maxProfit, prices[i] - minPrice);  
        	}
        }
        return maxProfit < 0 ? 0 : maxProfit;
    }
	public static void main(String[] args) {
		BuySellStock ob = new BuySellStock();
		
		int[] prices = {7,1,5,3,6,4};
		
		System.out.println(ob.maxProfit(prices));
	}

}
