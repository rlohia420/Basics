package leetcode.dp.medium;

public class CountSortedVowelStrings_1641 {
/*Example:
	Input: n = 1
	Output: 5
	Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].
*/
	public static int countVowelStrings(int n) {
	    int k = 5;
	    int[][] dp = new int[n+1][k+1];

	    for (int i = 1; i <= n; i++) {
	        for (int j = 1; j <= k; j++) {
	            if (i == 1) 
	            	dp[i][j] = j;
	            else dp[i][j] = dp[i][j-1] + dp[i-1][j];
	        }
	    }
	    return dp[n][k];
	}

	public static void main(String args[]) {
		System.out.println(countVowelStrings(4));
	}
}
