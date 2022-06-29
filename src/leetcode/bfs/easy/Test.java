package leetcode.bfs.easy;

public class Test {
		public static boolean stoneGame(int[] piles) {
	        int m =piles.length;
	        int findMax[][] = new int[m][m];
	        for(int i=0;i<m;i++){
	            findMax[i][i] = piles[i];
	        }
	        for(int l=2;l<=m;l++){
	            for(int i=0;i+l-1<m;i++){
	                int j = i+l-1;
	                int a = piles[i] - findMax[i+1][j];
	                int b = piles[j] - findMax[i][j-1];
	                findMax[i][j] = Integer.max(a,b);
	            }
	        }
			return findMax[0][m-1]>0;
	    }
	public static void main(String args[] ) {
		int[] piles = {5,3,4,5,6,5};
		System.out.println(stoneGame(piles));
	}
}
