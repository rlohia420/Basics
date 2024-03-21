package basic.dynamicProgramming.unbounded.knapsack;
//https://www.youtube.com/watch?v=I-l6PBeERuc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=16
public class CoinChangeProblem_MinNoOfCoins {
	public static int coinChange(int[] coins, int amount) {
		int dp[][] = new int[coins.length + 1][amount + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (j == 0) {
					dp[i][j] = 0;
				} else if (i == 0) {
					dp[i][j] = (int) 1e5;
				} else if (coins[i - 1] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
				}
			}
		}
		return dp[coins.length][amount] > (int) 1e4 ? -1 : dp[coins.length][amount];
	}
	
	public static void main(String args[]) {
		int[] coins = {1,4,10,1}; int amount = 6;
		int result = minimumCoin(coins,amount);
		System.out.println(result);
	}
	private static int minimumCoin(int[] coins , int amount){
		int n = coins.length;
		int[][] dp = new int[n+1][amount+1];
		for(int i=0;i<=coins.length;i++){
			for(int j=0;j<=amount;j++){
				if(j==0){
					dp[i][j] =1;
				}else if(i==0){
					dp[i][j]=0;
				}else if(coins[i-1]<j){
					dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
				}else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return  dp[n][amount];

	}
}
