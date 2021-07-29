package basic.dynamicProgramming.knapsack;

public class CountOfSubSetSum {
	static int isSubsetSum(int set[], int n, int sum) {
		int subset[][] = new int[sum + 1][n + 1];

		for (int i = 0; i <= n; i++)
			subset[0][i] = 1;

		for (int i = 1; i <= sum; i++)
			subset[i][0] = 0;

		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= n; j++) {
				subset[i][j] = subset[i][j - 1];
				if (i >= set[j - 1])
					subset[i][j] = subset[i][j] + subset[i - set[j - 1]][j - 1];
			}
		}
		return subset[sum][n];
	}

	/* Driver code */
	public static void main(String args[]) {
		int set[] = { 3, 34, 4, 12, 7, 2,1 };//{3,4} , {4,2,1}, {7}
		int sum = 7;
		int n = set.length;
		System.out.println("Found a subset" + " with given sum = "+isSubsetSum(set, n, sum));
	}
}
