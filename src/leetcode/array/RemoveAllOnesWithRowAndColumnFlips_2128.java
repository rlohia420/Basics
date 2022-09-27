package leetcode.array;

public class RemoveAllOnesWithRowAndColumnFlips_2128 {
	public static int count =0;
	 public static boolean canFlipToZero(int[][] matrix) {
	        int R = matrix.length, C = matrix[0].length;

	        for (int i = 0; i < R; i++) {
	            if (matrix[i][0] == 0) continue;
	            for (int j = 0; j < C; j++) {
	                matrix[i][j] ^= 1;
	            }count++;
	        }

	        for (int j = 0; j < C; j++) {
	            if (matrix[0][j] == 0) continue;
	            for (int i = 0; i < R; i++) {
	                matrix[i][j] ^= 1;
	            }count++;
	        }

	        for (int j = 0; j < C; j++) {
	            for (int i = 0; i < R; i++) {
	                if (matrix[i][j] == 1) return false;
	            }
	        }

	        return true;
	    }
	 public static void main(String args[]) {
		 int[][] matrix = {{0,0,1,0,0},
				 		   {0,0,1,0,0},
				 		   {0,0,1,0,0},
				 		   {1,1,0,1,1},
				 		   {0,0,1,0,0}};
		 System.out.println(canFlipToZero(matrix) +" , with round = "+count);
	 }
}
