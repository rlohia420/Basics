package basic.bfs.dfs;

import java.util.LinkedList;
import java.util.Queue;


public class CheckForPossiblePathIn2DMatrixUsingBFS {
	static class pair {
		int first, second;

		public pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	// Direction vectors
	static int dRow[] = { 1, 0 };
	static int dCol[] = { 0, 1 };

	// Function to check if a cell
	// is be visited or not
	static boolean isValid(int[][] arr,boolean vis[][], int row, int col, int rowLength, int colLength) {

		// If cell lies out of bounds
		if (row < 0 || col < 0 || row >= rowLength || col >= colLength)
			return false;

		// If cell is already visited
		if (vis[row][col])
			return false;

		 if(arr[row][col]!=0)
			 return false;
		// Otherwise
		return true;
	}

	static boolean BFS(int grid[][], boolean vis[][], int sRow, int sCol , int eRow , int eCol) {

		// Stores indices of the matrix cells
		Queue<pair> q = new LinkedList<>();

		// Mark the starting cell as visited
		// and push it into the queue
		q.add(new pair(sRow, sCol));
		vis[sRow][sCol] = true;

		// Iterate while the queue
		// is not empty
		while (!q.isEmpty()) {
			 pair cell = q.peek();
		        int x = cell.first;
		        int y = cell.second;
		        if(grid[x][y]==0)
		        	System.out.print("x= "+ x + " y = "+ y + "\n");
		        q.remove();
		   	 
		        // Go to the adjacent cells
		        for(int i = 0; i < 2; i++)
		        {
		            int adjx = x + dRow[i];
		            int adjy = y + dCol[i];
		 
		            if (isValid(grid,vis, adjx, adjy,eRow+1,eCol+1))
		            {
		                q.add(new pair(adjx, adjy));
		                vis[adjx][adjy] = true;
		            }
		        }
		}
		return (vis[eRow][eCol]);
		
	}

	public static void main(String args[]) {
		int[][] arr = { { 0,  0,  0, -1,  0 }, // o/p - yes
				        { -1, 0,  0, -1, -1 }, 
				        { 0,  0,  0, -1,  0 }, 
				        { -1, 0,  0,  0,  0 }, 
				        { 0,  0, -1,  0,  0 } };
		boolean result = false;
		int ROW = arr.length-1;
		int COL = arr[0].length-1;
		boolean [][] vis = new boolean[ROW+1][COL+1];
		 
		result = BFS(arr, vis, 0, 0,ROW,COL);
		System.out.println(result);
	}

}
