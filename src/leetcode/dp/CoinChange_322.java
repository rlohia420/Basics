package leetcode.dp;

public class CoinChange_322 {

	public static int coinChange(int[] coins, int amount) {
		int dp[][] = new int[coins.length + 1][amount + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (j == 0) {
					dp[i][j] = 0;
				}
				else if (i == 0) {
					dp[i][j] = Integer.MAX_VALUE;
				}else if (coins[i - 1] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i-1][j]);
				}
			}
		}
		return dp[coins.length][amount]> Integer.MAX_VALUE ? -1 : dp[coins.length][amount];
	
	}

	public static void main(String args[]) {
		int[] coins = { 1, 2, 4,4,1,1 };
		System.out.println(coinChange(coins, 7)); 
		//{3,3,3,2}, {3,3,3,1,1}, {3,3,2,2,1},{2,2,2,2,1,1,1},{2,2,2,2,3}
		//{3,2,2,2,1,1}
	}
}
