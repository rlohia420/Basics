package basic.bfs.dfs;


/*An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.

Return the modified image after performing the flood fill.
 */
public class FloodFill {
	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int color = image[sr][sc];
		if (color != newColor) {
			fill(image, sr, sc, color, newColor);
		}
		return image;
	}

	private static void fill(int[][] image, int sr, int sc, int color, int newColor) {
		int i = sr;
		int j = sc;
		int n = image.length - 1;
		int m = image[0].length - 1;
		if (i < 0 || i > n || j < 0 || j > m || color == newColor) {
			return;
		}
		if (image[i][j] != newColor && image[i][j] == color) {
			image[i][j] = newColor;
			fill(image, i + 1, j, color, newColor);
			fill(image, i - 1, j, color, newColor);
			fill(image, i, j + 1, color, newColor);
			fill(image, i, j - 1, color, newColor);
		}

	}

	public static void main(String args[]) {
		int[][] image = { { 0, 1, 1 }, 
						  { 0, 1, 0 }, 
						  { 1, 0, 1 } };
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++)
				System.out.print(image[i][j]);
			System.out.println();
		}
		System.out.println("---------");
		int sr = 1, sc = 1, newColor = 2;
		int[][] image1 = floodFill(image, sr, sc, newColor);
		for (int i = 0; i < image1.length; i++) {
			for (int j = 0; j < image1[0].length; j++)
				System.out.print(image1[i][j]);
			System.out.println();
		}
	}

}
