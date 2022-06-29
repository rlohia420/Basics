package basic.dynamicProgramming.lcs;

public class LongestRepeatingSubsequence {
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
	public static void main(String args[]) {
		String str = "abccgeedad";
		System.out.println(LCS(str.toCharArray(),str.toCharArray(),str.length(),str.length()));
	}
}
