package basic.dynamicProgramming.lcs;

public class LongestRepeatingSubsequence_3 {
	public static void main(String args[]) {
		String str = "abccgeedda";
		System.out.println(lcs(str.toCharArray(),str.toCharArray(),str.length(),str.length()));
	}
	public static int lcs(char[] X, char[] Y, int m, int n) {
		int dp[][] = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else if (X[i - 1] == Y[j - 1]  && i != j)
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		return dp[m][n];
	}

}
