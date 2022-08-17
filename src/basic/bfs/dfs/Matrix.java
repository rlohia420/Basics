package basic.bfs.dfs;

public class Matrix {
	/*
	 * Given an m x n binary matrix mat, return the distance of the nearest 0 for
	 * each cell. The distance between two adjacent cells is 1 Example 1: Input: mat
	 * = [[0,0,0],[0,1,0],[0,0,0]] Output: [[0,0,0],[0,1,0],[0,0,0]] Input: mat =
	 * [[0,0,0],[0,1,0],[1,1,1]] Output: [[0,0,0],[0,1,0],[1,2,1]]
	 */
	public static void main(String args[]) {
		//int[][] mat = { { 0, 0, 0 }, { 0, 1, 0 }, {1,1,1} };
		int[][] mat = { { 0, 1, 0 }, { 1, 1, 1 }, {1,1,1} };
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j]);
			}System.out.println();
		}
		
		System.out.println("RESULT");
		int[][] res = updateMatrix(mat);
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(res[i][j]);
			}System.out.println();
		}
	}

	public static int[][] updateMatrix(int[][] mat) {
		int r = mat.length, c = mat[0].length;

		int[][] dis = new int[r][c];

		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
				if (mat[i][j] == 0) {
					explore(mat, dis, dis[i][j], i + 1, j);
					explore(mat, dis, dis[i][j], i - 1, j);
					explore(mat, dis, dis[i][j], i, j + 1);
					explore(mat, dis, dis[i][j], i, j - 1);
				}

		return dis;
	}

	public static void explore(int[][] mat, int[][] dis, int wt, int i, int j) {
		if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] != 1)
			return;

		mat[i][j] = 2;

		if (dis[i][j] == 0 || wt + 1 < dis[i][j]) {
			dis[i][j] = wt + 1;
			explore(mat, dis, wt + 1, i + 1, j);
			explore(mat, dis, wt + 1, i - 1, j);
			explore(mat, dis, wt + 1, i, j + 1);
			explore(mat, dis, wt + 1, i, j - 1);
		}

		mat[i][j] = 1;
	}
	
}
