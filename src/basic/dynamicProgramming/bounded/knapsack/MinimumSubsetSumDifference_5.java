package basic.dynamicProgramming.bounded.knapsack;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=-GtpxG6l_Mc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=11
public class MinimumSubsetSumDifference_5 {
	//Here only the vector part is different than the subset sum problem , rest is same as subset problem
	public static int MinSubsetSumDiff(int arr[], int n) {
		int range = 0;
		for (int i = 0; i < n; i++)
			range += arr[i];

		List<Integer> v = isSubsetPoss(arr, n, range);
		int mn = Integer.MAX_VALUE;
		for (int i = 0; i < v.size(); i++)
			mn = Math.min(mn, Math.abs(range - 2 * v.get(i)));

		return mn;
	}
	
	public static List<Integer> isSubsetPoss(int arr[], int n, int sum) {
		boolean[][] t= new boolean[n + 1][sum + 1]; // DP - matrix
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

		List<Integer> v = new ArrayList<>(); // contains all subset sums possible with n elements
		for (int j = 0; j <= sum; j++)
			if (t[n][j] == true)
				v.add(j);

		return v;
	}
	public static void main(String args[]) {
		int[] arr = {1,2,7};
		System.out.println(MinSubsetSumDiff(arr,3));
	}

}
