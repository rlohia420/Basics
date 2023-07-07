package basic.bfs.dfs;

public class MaxAreaOfIsland {
	private static int count = 0;
    private static int res = 0;
	 public static int maxAreaOfIsland(int[][] grid) {
	        for(int i=0;i<grid.length;i++) {
	        	for(int j=0;j<grid[0].length;j++) {
	        		dfs(grid,i,j);
	        		res = Math.max(res, count);
	        		count=0;
	        	}
	        }
	        return res;
	 }
	 
	 private static void dfs(int[][] grid , int i , int j) {
		 if(i<0 || j<0 ||i>=grid.length ||j>=grid[0].length || grid[i][j]==0) {
			 return;
		 }
		 if(grid[i][j]==1) {
			 count++;
		 }
		 grid[i][j]=0;
		 dfs(grid,i+1,j);
		 dfs(grid,i-1,j);
		 dfs(grid,i,j+1);
		 dfs(grid,i,j-1);
	 }
	 
	 public static void main(String args[]) {
		 int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
				         {0,0,0,0,0,0,0,1,1,1,0,0,0},
				         {0,1,1,0,1,0,0,0,0,0,0,0,0},
				         {0,1,0,0,1,1,0,0,1,0,1,0,0},
				         {0,1,0,0,1,1,0,0,1,1,1,0,0},
				         {0,0,0,0,0,0,0,0,0,0,1,0,0},
				         {0,0,0,0,0,0,0,1,1,1,0,0,0},
				         {0,0,0,0,0,0,0,1,1,0,0,0,0}};
		 int[][] arr = {{1,0,1,1},
				 		{1,0,1,1},
				 		{1,1,0,1},
				 		{0,1,0,1}};
		 //int[][] arr1 = {{1,0,1},{1,0,0}};
		 System.out.println(maxAreaOfIsland(arr));
	 }
}
