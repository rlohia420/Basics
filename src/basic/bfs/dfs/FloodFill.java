package basic.bfs.dfs;

public class FloodFill {
	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int color = image[sr][sc];
		if(color!=newColor) {
			fill(image,sr,sc,color , newColor);
		}
		return image;
	}
		private static void fill(int[][] image , int sr , int sc , int color , int newColor) {
			int i=sr ; int j=sc;
			int n = image.length-1;
			int m = image[0].length-1;
			if(i<0 || i>n || j<0 || j>m || color ==newColor ) {
				return;
			}
			if(image[i][j]!=newColor && image[i][j]==color) {
				image[i][j] = newColor;
				fill(image , i+1,j,color, newColor);
				fill(image , i-1,j,color, newColor);
				fill(image , i,j+1,color, newColor);
				fill(image , i,j-1,color, newColor);
			}
			
		}
	public static void main(String args[]) {
		int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
		for(int i=0;i<image.length;i++) {
			for(int j=0;j<image[0].length;j++)
				System.out.print(image[i][j]);
			System.out.println();
		}
		System.out.println("---------");
		int sr = 1, sc = 1, newColor = 2;
		int[][] image1 = floodFill(image , sr,sc,newColor);
		for(int i=0;i<image1.length;i++) {
			for(int j=0;j<image1[0].length;j++)
				System.out.print(image1[i][j]);
		System.out.println();
		}
	}
	
	
}
