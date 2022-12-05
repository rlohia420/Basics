package leetcode.problems.houseRobber;

/*
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
Find the maximum profit you can achieve. You may complete at most two transactions.
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock 
before you buy again).

Example 1:
Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 */
public class BestTimeToBuyandSellStockIII_123 {
	public static int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        int sell1 = 0, sell2 = 0;
        for(int i:prices){                              // Assume we only have 0 money at first
        	sell2 = Math.max(sell2, buy2+i);     // The maximum if we've just sold 2nd stock so far.
            buy2    = Math.max(buy2, sell1-i);  // The maximum if we've just buy  2nd stock so far.
            sell1 = Math.max(sell1, buy1+i);     // The maximum if we've just sold 1nd stock so far.
            buy1    = Math.max(buy1,    -i);          // The maximum if we've just buy  1st stock so far. 
        }
        return sell2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }
	public static void main(String args[]) {
		 int[] stock = {1,2,12,4,15,10,2,13};
		 System.out.println(maxProfit(stock));
	 }
}
