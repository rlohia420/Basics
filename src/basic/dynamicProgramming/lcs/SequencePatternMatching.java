package basic.dynamicProgramming.lcs;

//https://www.youtube.com/watch?v=QVntmksK2es&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=30
//Return true if the string B contains String A's sequence
public class SequencePatternMatching {
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
	static boolean seqPatternMatching(String X, String Y, int n, int m) {
		return LCS(X.toCharArray(), Y.toCharArray(), n, m) == Math.min(n, m);
	}
	public static void main(String args[]) {
		String a = "abc";
		String b ="xaybdesc";
		System.out.println(seqPatternMatching(a,b,a.length(),b.length()));
	}
}
