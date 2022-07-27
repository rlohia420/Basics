package basic.dynamicProgramming.bounded.knapsack;

public class KanpsackBagUsingBottomUp_1 {

	static int knapSack(int W, int wt[], int val[], int n) {
		int i, j=0;
		int dp[][] = new int[n + 1][W + 1];
		for (i = 0; i <= n; i++) {
			for (j = 0; j <= W; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else if (wt[i - 1] <= j)
					dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]],
										dp[i - 1][j]);
				else
					dp[i][j] = dp[i - 1][j];
			}
		}

		return dp[n][W];
	}

	public static void main(String args[]) {
		int wt[] = new int[] {1,2,3};
		int val[] = new int[] { 10,15,40};
		int W = 5;
		int n = val.length;
		System.out.println(knapSack(W, wt, val, n));
	}
}
