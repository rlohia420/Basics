package leetcode.dfs;

public class NumberofClosedIslands_1254 {
	public static int closedIsland(int[][] grid) {
		int ans = 0, n = grid.length, m = grid[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 0) {
					if (dfs(grid, i, j, n, m))
						ans++;
				}
			}
		}
		return ans;
	}

	static boolean  dfs(int[][] arr, int i, int j, int n, int m) {
		if (i < 0 || j < 0 || i >= n || j >= m)
			return false;
		if (arr[i][j] == 1)
			return true;
		arr[i][j] = 1;
		boolean a = dfs(arr, i + 1, j, n, m);
		boolean b = dfs(arr, i, j + 1, n, m);
		boolean c = dfs(arr, i - 1, j, n, m);
		boolean d = dfs(arr, i, j - 1, n, m);
		return a && b && c && d;
	}
	public static void main(String args[]) {
		int[][] arr = {{0,0,1,0,0},{0,1,0,1,0},{0,1,1,1,0}};
		System.out.println(closedIsland(arr));
	}
}
