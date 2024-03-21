package basic.dynamicProgramming.unbounded.knapsack;

//No of ways to get the given sum from the combination of coins
//https://www.youtube.com/watch?v=I4UR2T6Ro3w&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=15
public class CoinChangeProblem_NoOfWays2 {
	public static int getMaxNumberOfWays(int coins[], int n, int sum) {
		int t[][] = new int[n + 1][sum + 1];
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= sum; j++)
				if(j==0)
					t[i][j]=1;
				else if(i == 0)
					t[i][j]=0;
				else if (coins[i - 1] <= j)
					t[i][j] = t[i - 1][j] + t[i][j - coins[i - 1]];
				else
					t[i][j] = t[i - 1][j];

		return t[n][sum];
	}
	public static void main(String args[]) {
		int[] coins = {1,2,3}; // {1,1,1,1,1,1} - {1,1,1,2} - {1,1,3} - {1,2,2} - {2,3}
		int sum = 5;
		System.out.println(getMaxNumberOfWays(coins,coins.length,sum));
	}
}
