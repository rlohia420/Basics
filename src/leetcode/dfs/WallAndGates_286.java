package leetcode.dfs;

public class WallAndGates_286 {
	public static void wallsAndGates(int[][] rooms) {
		if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
			return;
		}
		int m = rooms.length;
		int n = rooms[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (rooms[i][j] == 0) { // start from every gate
					boolean[][] isVisited = new boolean[m][n]; // each new gate, associated with a new isVisited map

					fill(rooms, i, j, -1, isVisited, m, n); // -1, to match itself in recursion
				}
			}
		}
	}

	public static void fill(int[][] rooms, int i, int j, int distance, boolean[][] isVisited, int m, int n) {

		// rooms[i][j] <= 0 meaning == -1 or == 0, both stop
		if (i < 0 || i >= m || j < 0 || j >= n || rooms[i][j] <= 0 || isVisited[i][j]) {
			return;
		} 

		rooms[i][j] = Math.min(rooms[i][j], distance + 1);
		isVisited[i][j] = true;

		fill(rooms, i - 1, j, distance + 1, isVisited, m, n);
		fill(rooms, i, j + 1, distance + 1, isVisited, m, n);
		fill(rooms, i + 1, j, distance + 1, isVisited, m, n);
		fill(rooms, i, j - 1, distance + 1, isVisited, m, n);

		isVisited[i][j] = false;
	}

	public static void main(String args[]) {
		int[][] arr = { { 123456789, -1, 0, 123456789 }, { 123456789, 123456789, 123456789, -1 },
				{ 123456789, -1, 123456789, -1 }, { 0, -1, 123456789, 123456789 } };
		wallsAndGates(arr);
	}

}
