package leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestCommomSubsequenceBetweenSortedArray_1940 {
	
	public static void main(String args[]) {
		int[][] arrays = {{1,3,4,8,9},
	                 {1,4,7,9}};
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count = arrays.length;
		int shortestIndex = 0, shortestLength = arrays[0].length;
		for (int i = 0; i < count; i++) {
			int[] array = arrays[i];
			if (array.length < shortestLength) {
				shortestIndex = i;
				shortestLength = array.length;
			}
			for (int num : array)
				map.put(num, map.getOrDefault(num, 0) + 1);
		}
		List<Integer> subsequence = new ArrayList<Integer>();
		int[] shortestArray = arrays[shortestIndex];
		for (int i = 0; i < shortestLength; i++) {
			int num = shortestArray[i];
			if (map.get(num) == count)
				subsequence.add(num);
		}
		for(int i=0;i<subsequence.size();i++)
			System.out.println(subsequence.get(i));
		
		lcs(arrays[0],arrays[1],arrays[0].length,arrays[1].length);
	}
	
	public static int lcs(int[] X, int[] Y, int m, int n) {
		int dp[][] = new int[m + 1][n + 1];

		/*
		 * Following steps build L[m+1][n+1] in bottom up fashion. Note that L[i][j]
		 * contains length of LCS of X[0..i-1] and Y[0..j-1]
		 */
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else if (X[i - 1] == Y[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		System.out.println("count = "+dp[m][n]);
		return dp[m][n];
	}
}
