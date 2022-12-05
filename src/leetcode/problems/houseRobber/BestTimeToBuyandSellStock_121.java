package leetcode.problems.houseRobber;

/*
 * You are given an array prices where prices[i] 
 * is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy 
one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. 
If you cannot achieve any profit, return 0.
 */
public class BestTimeToBuyandSellStock_121 {
	 public static int maxProfit(int[] prices) {
         int buy = prices[0];
         if(prices.length==1) {
        	 return buy;
         }
         int[] dp = new int[prices.length];
         for(int i=1;i<prices.length;i++) {
        	// Checking for lower buy value
        	 buy = Math.min(buy, prices[i]);
        	// Checking for higher profit
        	 dp[i] = Math.max(dp[i-1], prices[i]-buy);
        	
         }
         return dp[prices.length-1];
    }
	 
	 public static void main(String args[]) {
		 int[] stock = {12,2,12,4,15,10};
		 System.out.println(maxProfit(stock));
	 }
}
