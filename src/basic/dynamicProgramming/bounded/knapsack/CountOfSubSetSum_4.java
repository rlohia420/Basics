package basic.dynamicProgramming.bounded.knapsack;

public class CountOfSubSetSum_4 {

	static int subsetSum(int arr[], int n, int sum) {
		int t[][] = new int[n + 1][sum + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {
				if (i == 0)
					t[i][j] = 0;
				if (j == 0)
					t[i][j] = 1;
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (arr[i - 1] <= j)
					t[i][j] = t[i - 1][j] + t[i - 1][j - arr[i - 1]] ;
				else
					t[i][j] = t[i - 1][j];
			}
		}

		return t[n][sum];
	}
	
	
	/* Driver code */
	public static void main(String args[]) {
		int set[] = { 3, 34, 4, 12, 7, 2,1 };//{3,4} , {4,2,1}, {7}
		int sum = 15;
		int n = set.length;
		System.out.println("Found a subset" + " with given sum = "+subsetSum(set, n, sum));
	}
}
