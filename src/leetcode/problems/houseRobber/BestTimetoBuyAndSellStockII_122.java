package leetcode.problems.houseRobber;
//consider complete array for loss and profit - tip
/*
 * You are given an integer array prices where prices[i] is 
 * the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock.
 You can only hold at most one share of the stock at any time.
 However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
 */
public class BestTimetoBuyAndSellStockII_122 {
	 public static int maxProfit(int[] prices) {
	        int n = prices.length;
	        int[] dp = new int[n];
	        dp[0]=0;
	        for(int i=1;i<n;i++){
	            dp[i] = dp[i-1] + Math.max(0,prices[i]-prices[i-1]);
	        }
	        return dp[n-1];
	    }
	 public static void main(String args[]) {
		 //int[] stock = {1,2,12,4,15,10,2,13,1,21};
		 int[] stock = { 12,2,12,4,15,10};
		 System.out.println(maxProfit(stock));
	 }
}
