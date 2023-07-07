package basic.bfs.dfs;

import java.util.Arrays;

public class ReplaceAllOccurrencesOf0ThatAreSurroundedby1InABinaryMatrix {
//https://www.techiedelight.com/replace-occurrences-of-0-surrounded-by-1-matrix/
	private static final int[] row = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] col = {-1, 0, 1, -1, 1, -1, 0, 1};
 
    // The function returns true if it is possible to go to cell `(x, y)`
    // It returns false when the cell is invalid or is different from the target
    private static boolean isSafe(int[][] mat, int x, int y, int target)
    {
        int M = mat.length;
        int N = mat[0].length;
 
        return (x >= 0 && x < M && y >= 0 && y < N) &&
                        mat[x][y] == target;
    }
 
    // Flood fill using DFS
    private static void floodfill(int[][] mat, int x, int y, int replacement)
    {
        // get the target value
        int target = mat[x][y];
 
        // replace current cell value with that of replacement
        mat[x][y] = replacement;
 
        // process all eight adjacent cells of the current cell and
        // recur for each valid cell
        for (int k = 0; k < 8; k++)
        {
            // if the adjacent cell at position `(x + row[k], y + col[k])` is
            // valid and has the same value as that of the current cell
            if (isSafe(mat, x + row[k], y + col[k], target)) {
                floodfill(mat, x + row[k], y + col[k], replacement);
            }
        }
    }
 
    // Replace all occurrences of 0 by 1, which are surrounded
    // by 1 in a binary matrix
    public static void replaceZeroes(int[][] mat)
    {
        // base case
        if (mat == null || mat.length == 0) {
            return;
        }
 
        // `M × N` matrix
        int M = mat.length;
        int N = mat[0].length;
 
        // visit all cells in the first and last row of the matrix
        for (int i = 0; i < N; i++)
        {
            if (mat[0][i] == 0) {
                floodfill(mat, 0, i, -1);
            }
 
            if (mat[M - 1][i] == 0) {
                floodfill(mat, M - 1, i, -1);
            }
        }
 
        // visit all cells in the first and last column of the matrix
        for (int i = 0; i < M; i++)
        {
            if (mat[i][0] == 0) {
                floodfill(mat, i, 0, -1);
            }
 
            if (mat[i][N - 1] == 0) {
                floodfill(mat, i, N - 1, -1);
            }
        }
 
        // traverse the given matrix
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                // replace every 0 with 1
                if (mat[i][j] == 0) {
                    mat[i][j] = 1;
                }
 
                // replace every -1 with 0
                if (mat[i][j] == -1) {
                    mat[i][j] = 0;
                }
            }
        }
    }
 
    public static void main(String[] args)
    {
        int[][] mat =
        {
            { 1, 1, 1, 1, 0, 0, 1, 1, 0, 1 },
            { 1, 0, 0, 1, 1, 0, 1, 1, 1, 1 },
            { 1, 0, 0, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 0, 0, 1, 1, 0, 1 },
            { 0, 0, 1, 1, 0, 0, 0, 1, 0, 1 },
            { 1, 0, 0, 1, 1, 0, 1, 1, 0, 0 },
            { 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 0, 1, 1, 0, 0, 1, 0, 1 },
            { 1, 1, 1, 0, 1, 0, 1, 0, 0, 1 },
            { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 }
        };
 
        replaceZeroes(mat);
 
        for (int[] r: mat) {
            System.out.println(Arrays.toString(r));
        }
    }
}
