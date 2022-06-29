package basic.dynamicProgramming.lcs;

public class CountOfLongestCommonSubsequenceUsingTopDown {
	//https://www.youtube.com/watch?v=hR3s9rGlMTU
	//https://github.com/shubhamchemate003/Dynamic-Programming-Questions-by-Aditya-Verma/blob/main/LCS_bottom_up_dp.cpp
	public static int lcs(char[] X, char[] Y, int m, int n) {
		int dp[][] = new int[m + 1][n + 1];

		/*
		 * Following steps build L[m+1][n+1] in bottom up fashion. Note that L[i][j]
		 * contains length of LCS of X[0..i-1] and Y[0..j-1]
		 */
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else if (X[i - 1] == Y[j - 1])
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		String s1 = "ABCD";
		String s2 = "GXTXAYB";

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;

		System.out.println("Length of LCS is" + " " + lcs(X, Y, m, n));
	}

}
