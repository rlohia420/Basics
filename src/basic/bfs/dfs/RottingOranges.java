package basic.bfs.dfs;

public class RottingOranges {
	public static void main(String args[]) {
		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		System.out.println(orangesRotting1(grid));
	}

	public static int orangesRotting1(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2)
					dfs(grid, i, j, 2);
			}
		}
		int min = 2;
		for (int[] row : grid) {
			for (int i : row) {
				if (i == 1)
					return -1;
				min = Math.max(min, i);
			}
		}
		return min - 2;
	}

	private static void dfs(int[][] grid, int row, int col, int time) {
		if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0
				|| (1 < grid[row][col] && grid[row][col] < time))
			return;
		else {
			grid[row][col] = time;
			dfs(grid, row + 1, col, time + 1);
			dfs(grid, row - 1, col, time + 1);
			dfs(grid, row, col + 1, time + 1);
			dfs(grid, row, col - 1, time + 1);
		}
	}
}
