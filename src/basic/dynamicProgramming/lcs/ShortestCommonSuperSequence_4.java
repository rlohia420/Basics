package basic.dynamicProgramming.lcs;

public class ShortestCommonSuperSequence_4 {

	public static int lcs(char[] X, char[] Y, int m, int n) {
		int dp[][] = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else if (X[i - 1] == Y[j - 1])// when last character is same
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else// when last character is not same -> pick max
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		return dp[m][n];
	}

	static int SCS(char[] X, char[] Y, int n, int m) {
		return m + n - lcs(X, Y, n, m);
	}
	public static void main(String args[]) {
		//String x = "abcgefghasdc";
		//String y = "abcxefy";
		String x="ababc";
		String y="abcde";
		int m = x.length();
		int n = y.length();
		System.out.println(SCS(x.toCharArray(), y.toCharArray(), m, n));
	}
	
}
