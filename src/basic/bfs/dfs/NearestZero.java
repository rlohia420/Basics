package basic.bfs.dfs;

public class NearestZero {
	public static void main(String args[]) {
		int[][] mat = { { 0, 0, 0 }, { 0, 1, 0 }, {1,1,1} };
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j]);
			}System.out.println();
		}
		
		System.out.println("RESULT");
		updateMatrix(mat);
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j]);
			}System.out.println();
		}
	}
	static int[][] directions = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
    static boolean[][] visited;
    
    public static int[][] updateMatrix(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        visited = new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(mat[i][j]==0){
                    dfs(mat,i,j,rows,cols,0);
                }
            }
        }
        return mat;
    }
    //level denotes the distance between the cell with 0 we are currently processing and 1
    private static void dfs(int[][] mat, int i, int j, int rows, int cols, int level){
        if(i < 0 || i >= rows || j < 0 || j >= cols || (mat[i][j]==0 && level != 0)){
            return ;
        }    
        
        if(visited[i][j] && mat[i][j] <= level){
            return;
        }
        mat[i][j] = level;
        visited[i][j] = true;
        for(int k=0;k<4;k++){
            dfs(mat,i+directions[k][0], j+directions[k][1], rows,cols,level+1);
        }
    }
	
}
