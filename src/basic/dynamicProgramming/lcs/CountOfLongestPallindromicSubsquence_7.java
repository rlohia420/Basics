package basic.dynamicProgramming.lcs;

public class CountOfLongestPallindromicSubsquence_7 {

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

	
	public static int LPS(String X, int n) {
		String rev = new StringBuilder(X).reverse().toString();
		return lcs(X.toCharArray(), rev.toCharArray(), n, n);
	}
	
	public static void main(String args[]) {
		//System.out.println(LPS("NEHALOHIAIHOLNEHA","NEHALOHIAIHOLNEHA".length()));
		System.out.println("abcdfgcba = "+ LPS("abcdfgcba","abcdfgcba".length()));
		System.out.println("acadac = "+LPS("acadac","acadac".length()));
		
		System.out.println("NEHALOHIAIHOLNEHA = "+LPS("NEHALOHIAIHOLNEHA","NEHALOHIAIHOLNEHA".length()));
	}
}

