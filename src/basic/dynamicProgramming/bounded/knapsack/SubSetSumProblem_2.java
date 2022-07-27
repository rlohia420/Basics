package basic.dynamicProgramming.bounded.knapsack;

public class SubSetSumProblem_2 {

	static boolean isSubsetSum(int arr[], int n, int sum) {
		boolean[][] t = new boolean[n + 1][sum + 1]; // DP - matrix
		// initialization
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {
				if (i == 0)
					t[i][j] = false;
				if (j == 0)
					t[i][j] = true;
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (arr[i - 1] <= j)
					t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
				else
					t[i][j] = t[i - 1][j];
			}
		}

		return t[n][sum];
	}

	/* Driver code */
	public static void main(String args[]) {
		int set[] = { 3, 4, 5, 2 };
		int sum = 91;
		int n = set.length;
		if (isSubsetSum(set, n, sum) == true)
			System.out.println("Found a subset" + " with given sum");
		else
			System.out.println("No subset with" + " given sum");
	}
}
