package basic.dynamicProgramming.lcs;

//https://www.youtube.com/watch?v=-fx6aDxcWyg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=25
public class MinimumNumberOfInsertionAndDeletionToConvertAToB {

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
	public static int minInsertDel(char[] X, char[] Y, int n, int m) {
		int lcs_len = LCS(X, Y, n, m);
		// heap , pea => ea <LCS>
				//number of deletion => heap - ea =2
				//number of insertion => pea - ea =1
				// OR heap + pea = 2(ea);
		return m + n - 2 * lcs_len;
	}
	public static void main(String args[]) {
		String a= "heap" , b = "pea";
		
		System.out.println(minInsertDel(a.toCharArray(),b.toCharArray(),a.length(),b.length()));
	}
}
