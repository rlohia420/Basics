package basic.dynamicProgramming.lcs;

//https://www.youtube.com/watch?v=AEcRW4ylm_c&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=31
//Number of insertion will be equal to the number of deletion
public class MinNumberOfInsertionInAStringToMakeStringPallindrome {
	public static int LCS(char[] X, char[] Y, int n, int m) {
		int[][] dp=new int[n + 1][m + 1]; // DP - matrix
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= m; j++)
				if (i == 0 || j == 0)
					dp[i][j] = 0;

		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= m; j++)
				if (X[i - 1] == Y[j - 1] && i != j)
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);

		return dp[n][m];
	}

	public static int LPS(String X, int n) {
		String rev =  new StringBuilder(X).reverse().toString();
		return LCS(X.toCharArray(), rev.toCharArray(), n, n);
	}

	public static int minInsertionForPallindrome(String X, int n) {
		return n - LPS(X, n);
	}
	public static void main(String args[]) {
		System.out.println(minInsertionForPallindrome("abcdecba","abcdecba".length()));
	}
}
