package basic.dynamicProgramming.lcs;

import java.util.Arrays;

public class CountOfLongestCommonSubString {

	public static void main(String args[]) {
		String x = "abcgefgh";
		String y = "abcxefy";
		int m = x.length();
		int n = y.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		int count=0;
		System.out.println(lcsubstring(x, y, m, n,count));
	}

	private static int lcsubstring(String x, String y, int m, int n, int count) {
		if (m == 0 || n == 0) {
			 return count;
		}
		if (x.charAt(m - 1) == y.charAt(n - 1)) {
			count = lcsubstring(x, y, m-1, n-1, count+1);
		}
		int count1  = lcsubstring(x, y, m - 1,n, 0);
		int count2  = lcsubstring(x, y, m , n - 1, 0);
				
		return Math.max(count,Math.max(count1,count2));
	}
}