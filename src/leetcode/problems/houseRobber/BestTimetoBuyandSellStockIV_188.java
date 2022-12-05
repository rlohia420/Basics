package leetcode.problems.houseRobber;

import java.util.Arrays;

/*
 * You are given an integer array prices where prices[i] 
 * is the price of a given stock on the ith day, and an integer k.

Find the maximum profit you can achieve. 
You may complete at most k transactions.

Note: You may not engage in multiple transactions simultaneously 
(i.e., you must sell the stock before you buy again).
 */
public class BestTimetoBuyandSellStockIV_188 {
	public static int maxProfit(int k, int[] prices) {
		if (k == 0) {
			return 0;
		}

		int[] buy = new int[k + 1]; // buy[i]: min cost at (i + 1)-th time stock purchased
		int[] sell = new int[k + 1]; // sell[i]: max revenue at (i + 1)-th time stock sold
		Arrays.fill(buy, Integer.MIN_VALUE);
		Arrays.fill(sell, 0);

		for (int i = 0; i < prices.length; i++) {
			for (int j = k; j > 0; j--) {
				buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
				sell[j] = Math.max(sell[j], prices[i] + buy[j]);
			}
		}

		return sell[k];
	}

	public static void main(String args[]) {
		int[] stock = { 12,2,12,4,15,10};
		System.out.println(maxProfit(1, stock));
	}
}
