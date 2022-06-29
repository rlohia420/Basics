package basic.dynamicProgramming.lcs;

public class ShortestCommonSuperSequence {
	public static int LCS(char[] X, char[] Y, int n, int m) {
		int[][] dp= new int[n + 1][m + 1]; // DP - matrix

		// base case of recursion --> for initialization of dp - matrix
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= m; j++)
				if (i == 0 || j == 0)
					dp[i][j] = 0;

		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= m; j++)
				if (X[i - 1] == Y[j - 1]) // when last character is same
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else // when last character is not same -> pick max
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);

		return dp[n][m];
	}

	static int SCS(char[] X, char[] Y, int n, int m) {
		return m + n - LCS(X, Y, n, m);
	}
	public static void main(String args[]) {
		String x = "abcgefgh";
		String y = "abcxefy";
		//String x="ababc";
		//String y="abcde";
		int m = x.length();
		int n = y.length();
		System.out.println(SCS(x.toCharArray(), y.toCharArray(), m, n));
	}
	
}
