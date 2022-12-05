package leetcode.dp;

import java.util.Arrays;

public class CoinChange_2_518 {
	public static int getMaxNumberOfWays(int coins[], int n, int sum) {
		int t[][] = new int[n + 1][sum + 1];
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= sum; j++)
				if(i==0)
					t[i][j]=0;
				else if(j == 0)
					t[i][j]=1;
				else if (coins[i - 1] <= j)
					t[i][j] = t[i - 1][j] + t[i][j - coins[i - 1]];
				else
					t[i][j] = t[i - 1][j];

		return t[n][sum];
	}
//	public static void main(String args[]) {
//		int[] coins = {1,2,3}; // {1,1,1,1,1,1} - 
//		int sum = 5;
//		System.out.println(getMaxNumberOfWays(coins,coins.length,sum));
//	}
	
	 public static void main(String args[]){
		 int arr[] = {3,2,1,1,2,3,1};
	        printMinOp(arr,arr.length);
	 }
	 static void printMinOp(int A[],int n)
	    {
		// Initialize cost to 0
		    int cost = 0;
		 
		    // Sort the array
		    Arrays.sort(A);
		 
		    // Middle element
		    int K = A[n / 2];
		 
		    // Find Cost
		    for (int i = 0; i < n; ++i)
		        cost += Math.abs(A[i] - K);
		 
		    // If n, is even. Take minimum of the
		    // Cost obtained by considering both
		    // middle elements
		    if (n % 2 == 0) {
		        int tempCost = 0;
		 
		        K = A[(n / 2) - 1];
		 
		        // Find cost again
		        for (int i = 0; i < n; ++i)
		            tempCost += Math.abs(A[i] - K);
		 
		        // Take minimum of two cost
		        cost = Math.min(cost, tempCost);
		    }
		 
		    // Return total cost
		    System.out.println(cost);
	    }
}
