package basic.dynamicProgramming.bounded.knapsack;

public class EqualSumPartition_3 {
	public static void main(String args[]) {
		int set[] = { 1,5,5,11 };
		if (isEqualSumPartition(set) == true)
			System.out.println("Found equal sum partion");
		else
			System.out.println("No equal sum partition");
	}
	public static boolean isEqualSumPartition(int set[]){
		int sum=0;
		for(int i=0;i<set.length;i++) {
			sum=sum+set[i];
		}
		if(sum%2==0) {
			return isSubsetSum(set,set.length,sum/2);
		}else {
			return false;
		}
		
	}
	static boolean isSubsetSum(int arr[], int n, int sum) {
		boolean dp[][] = new boolean[n + 1][sum + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {
				if (i == 0)
					dp[i][j] = false;
				if (j == 0)
					dp[i][j] = true;
			}
		}


		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (arr[i - 1] <= j)
					dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
				else
					dp[i][j] = dp[i - 1][j];
			}
		}

		return dp[n][sum];
	}
}
