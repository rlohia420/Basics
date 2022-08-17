package basic.dynamicProgramming.common;

/*
 * You are given a grid of size n*m where n and m represent rows and columns 
 * respectively and the grid as a whole represents a gold mine.
You are standing in front of the left wall and are supposed to dig to the right wall. 
You can start from any row in the left wall.
You are allowed to move 1 cell right-up (d1), 1 cell right (d2) or 1 cell right-down (d3).
Each cell has a value that is the amount of gold available in the cell.
You are required to identify the maximum amount of gold that can be dug out from the mine.

 */
//https://www.youtube.com/watch?v=hs0lilfJ7C0&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=9
public class Goldmine {
	public static void main(String[] args) throws Exception {

	}
	public static void goldMine(int m , int n , int[][] arr) {
		int[][] dp = new int[n][m]; // 2
		for (int j = m - 1; j >= 0; j--) { // 3 start from last column
			for (int i = n - 1; i >= 0; i--) { // 4
				if (j == m - 1) {
					dp[i][j] = arr[i][j]; // 5
				} else if (i == 0) { // 6
					dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
				} else if (i == n - 1) { // 7
					dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
				} else { // 8
					dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], Math.max(dp[i + 1][j + 1], dp[i - 1][j + 1]));
				}
			}

		}
		int max = dp[0][0]; // 9
		for (int i = 1; i < n; i++) {
			if (dp[i][0] > max) // 10
				max = dp[i][0];
		}
		System.out.println(max); // 11
	}
}
