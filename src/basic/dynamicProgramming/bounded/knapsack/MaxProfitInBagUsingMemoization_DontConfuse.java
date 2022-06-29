package basic.dynamicProgramming.bounded.knapsack;

public class MaxProfitInBagUsingMemoization_DontConfuse {
	// Memoization version
	public static int knapsack(int[] weights, int[] profit, int w, int n, int t[][]) {

		if (w == 0 || n == 0) {
			return 0;
		}
		if (t[n][w] != -1) {
			return t[n][w];
		}
		if (weights[n - 1] > w) {
			return t[n][w] = knapsack(weights, profit, w, n - 1, t);

		} else {
			return t[n][w] = Math.max(profit[n - 1] + knapsack(weights, profit, w - weights[n - 1], n - 1, t),
					knapsack(weights, profit, w, n - 1, t));
		}
		// return t[n][w];
	}

	public static void main(String args[]) {

		int[] profit = { 60, 100, 120 };
		int[] weights = { 10, 20, 30 };
		int w = 50;
		int n = 3;
		int t[][] = new int[n + 1][w + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= w; j++) {
				t[i][j] = -1;
			}
		}
		System.out.println(knapsack(weights, profit, w, n, t));
	}
}
