package basic.bfs.dfs;

public class CheckForPossiblePathIn2DMatrix {

	public static void main(String args[]) {
		int[][] arr = 
			  { {  0, 0,  0, -1,  0 }, // o/p - yes
				{ -1, 0,  0, -1, -1 }, 
				{  0, 0,  0, -1,  0 }, 
				{ -1, 0,  0,  0,  0 }, 
				{  0, 0, -1,  0,  0 } };
		int m = arr.length - 1;
		int n = arr[0].length - 1;
		boolean result = false;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 0) {
					result = check(arr, 0, 0, m, n);
				}
			}
		}
		System.out.println(result);
	}

	public static boolean check(int[][] arr, int i, int j, int m, int n) {
		if (i < 0 || j < 0 || i > m || j > n) {
			return false;
		}

		if (arr[i][j] == 0 && i == m && j == n) {
			return true;
		}

		if (arr[i][j] == 0) {
			boolean r1 = check(arr, i + 1, j, m, n);
			boolean r2 = check(arr, i, j + 1, m, n);
			return r1 || r2;
		}
		return false;
	}

}
