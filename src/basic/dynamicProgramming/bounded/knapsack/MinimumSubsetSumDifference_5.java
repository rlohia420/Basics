package basic.dynamicProgramming.bounded.knapsack;

//https://www.youtube.com/watch?v=-GtpxG6l_Mc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=11
public class MinimumSubsetSumDifference_5 {
	// Here only the vector part is different than the subset sum problem , rest is
	// same as subset problem
	public static int minSubsetSumDiff(int arr[], int n) {
		 int sum = 0;
	        for (int i = 0; i < n; i++)
	            sum += arr[i];
	 
		boolean[][] dp= isSubsetPoss(arr,n,sum); 
		int diff = Integer.MAX_VALUE;
		 
	        // Find the largest j such that dp[n][j]
	        // is true where j loops from sum/2 t0 0
	        for (int j = sum / 2; j >= 0; j--) {
	            // Find the
	            if (dp[n][j] == true) {
	                diff = sum - 2 * j;
	                break;
	            }
	        }
	        return diff;

	}

	public static boolean[][] isSubsetPoss(int arr[], int n, int sum) {
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
		return t;
	}

	public static void main(String args[]) {
		/*
		 * Input: arr[] = {1, 6, 11, 5} Output: 1 Explanation: Subset1 = {1, 5, 6}, sum
		 * of Subset1 = 12 Subset2 = {11}, sum of Subset2 = 11
		 */

		int[] arr = { 1, 6, 11, 5 ,3};
		System.out.println(minSubsetSumDiff(arr, arr.length));
	}
}
