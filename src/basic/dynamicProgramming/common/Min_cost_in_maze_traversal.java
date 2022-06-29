package basic.dynamicProgramming.common;

/*
 * You are given an array of dimensions n*m , representing elements of 2d array a, which represents a maze.
You are standing in the top-left cell and are required to move to the bottom-right cell.
You are allowed to move 1 cell right (h move) or 1 cell down (v move) in 1 move.
Each cell has a value that will have to be paid to enter that cell (even for the top-left and bottom-right cell).
You are required to traverse through the matrix upto the bottom-right most cell and print the cost of the path which is the least costly.
 */
public class Min_cost_in_maze_traversal {
	public static void main(String[] args) throws Exception {
		int n = 4;
		int m = 4;
		int[][] arr = new int[n][m];

	}

	public static void minCost(int n, int m, int[][] arr) {
		int[][] dp = new int[n][m]; // 2
		for (int i = n - 1; i >= 0; i--) { // 3
			for (int j = m - 1; j >= 0; j--) { // 4
				if (i == n - 1 && j == m - 1) { // 5
					dp[i][j] = arr[i][j];
				} else if (i == n - 1) { // 6
					dp[i][j] = arr[i][j] + dp[i][j + 1];
				} else if (j == m - 1) { // 7
					dp[i][j] = arr[i][j] + dp[i + 1][j];
				} else { // 8
					int min = Math.min(dp[i + 1][j], dp[i][j + 1]);
					dp[i][j] = arr[i][j] + min;
				}
			}
		}
		System.out.println(dp[0][0]); // 9
	}
}
