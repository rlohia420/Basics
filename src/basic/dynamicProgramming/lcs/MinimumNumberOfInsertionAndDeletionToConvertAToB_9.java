package basic.dynamicProgramming.lcs;

//https://www.youtube.com/watch?v=-fx6aDxcWyg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=25
public class MinimumNumberOfInsertionAndDeletionToConvertAToB_9 {
	public static int lcs(char[] X, char[] Y, int m, int n) {
		int dp[][] = new int[m + 1][n + 1];
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
	public static int minInsertDel(char[] X, char[] Y, int n, int m) {
		int lcs_len = lcs(X, Y, n, m);
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
