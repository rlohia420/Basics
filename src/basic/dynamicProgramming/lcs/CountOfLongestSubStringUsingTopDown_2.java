package basic.dynamicProgramming.lcs;

public class CountOfLongestSubStringUsingTopDown_2 {
	public static int LCSubstr(char[] X, char[] Y, int m, int n) {
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
					dp[i][j] = 0;
			}
		}
		int mx = Integer.MIN_VALUE;
		for (int i = 0; i <= m; i++)
			for (int j = 0; j <= n; j++)
				mx = Math.max(mx, dp[i][j]);

		return mx;
	}
	public static void main(String args[]) {
		//String x = "abcgefgh";
		//String y = "abcxefy";
		String x="ababcde";
		String y="abcabcde";
		int m = x.length();
		int n = y.length();
		int count=0;
		System.out.println(LCSubstr(x.toCharArray(), y.toCharArray(), m, n));
	}
}
