package basic.dynamicProgramming.lcs;

import java.util.Arrays;

public class CountOfLongestCommonSubsequenceUsingMemoization {

	public static void main(String args[]) {
		String x="abcgefgh";
		String y="abcxefy";
		int m = x.length();
		int n = y.length();
		int[][] dp = new int[m+1][n+1];
		 for (int[] row : dp) {
	            Arrays.fill(row, -1);
	        }
		System.out.println(lcs(x,y,m,n,dp));
	}
	
	private static int lcs(String x, String y, int m , int n , int[][]dp) {
		if(m==0||n==0) {
			return 0;
		}
		if(dp[m][n]!=-1) {
			return dp[m][n];
		}
		if(x.charAt(m-1)==y.charAt(n-1)) {
			return dp[m][n]= 1+ lcs(x,y,m-1,n-1,dp);
		}else {
			return dp[m][n]= Math.max(lcs(x,y,m,n-1,dp),lcs(x,y,m-1,n,dp));
		}
	}
	
}
