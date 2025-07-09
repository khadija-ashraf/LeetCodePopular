package com.leetcode;


// Greedy approach
public class BuySellStock2 {
	//Key Insight:

	// If you are allowed to buy and sell multiple times, 
	// then summing up all small gains is the same as
	// — or better than — trying to find far-apart highs and lows
	
	// Let’s say we have this price trend: prices = [1, 2, 3, 4, 5]
	// If we try to buy at 1 and sell at 5, we make: Profit = 5 - 1 = 4
	
	// But if we use the greedy strategy of comparing consecutive days:
	// Day 0 to 1: 2 - 1 = 1
	// Day 1 to 2: 3 - 2 = 1
	// Day 2 to 3: 4 - 3 = 1
	// Day 3 to 4: 5 - 4 = 1
	// Total profit = 1 + 1 + 1 + 1 = 4
	
	// Why does it work?
	// Because stock prices are cumulative:
	//	•	If the price is going up across multiple days,
	//	•	Then every small rise contributes to the total rise,
	//	•	So taking all small profits = taking one big profit.
	// And if there’s a dip in between, the greedy approach avoids losses.
	
//	What if you try to look far ahead?
//			Looking for global minima and maxima (i.e., far apart days) 
//	 		adds complexity and is unnecessary, because:
//				•	You might miss small profitable trades,
//				•	You have to track holding state, local dips, multiple comparisons,
//				•	But greedy handles all that by default in a simple loop.
//
//			⸻
//
//			Greedy wins because:
//				•	The problem allows unlimited transactions. 
//					because we can buy right after selling the same day. 
//					The buying price will be the same as the selling price.
//				•	We just need to capture every small rise.
//				•	That’s exactly what comparing prices[i+1] > prices[i] does.

	
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
