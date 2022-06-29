package leetcode.array.medium;
/*
 * This question is about implementing a basic elimination algorithm for Candy Crush.

 Given a 2D integer array board representing the grid of candy, different positive integers board[i][j] represent different types of candies.
 A value of board[i][j] = 0 represents that the cell at position (i, j) is empty.
 The given board represents the state of the game following the player's move.

 Now, you need to restore the board to a stable state by crushing candies according to the following rules:

     If three or more candies of the same type are adjacent vertically or horizontally, "crush" them all at the same time - these positions become empty.
     After crushing all candies simultaneously, if an empty space on the board has candies on top of itself, then these candies will drop until they hit a candy or bottom at the same time. (No new candies will drop outside the top boundary.)
     After the above steps, there may exist more candies that can be crushed. If so, you need to repeat the above steps.
     If there does not exist more candies that can be crushed (ie. the board is stable), then return the current board.
     You need to perform the above rules until the board becomes stable, then return the current board.


 Example:

 Input:
 board =
 [[110,5,112,113,114],[210,211,5,213,214],[310,311,3,313,314],[410,411,412,5,414],[5,1,512,3,3],[610,4,1,613,614],[710,1,2,713,714],[810,1,2,1,1],[1,1,2,2,2],[4,1,4,4,1014]]

 Output:
 [[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[110,0,0,0,114],[210,0,0,0,214],[310,0,0,113,314],[410,0,0,213,414],[610,211,112,313,614],[710,311,412,613,714],[810,411,512,713,1014]]

 Explanation:


 Note:
     The length of board will be in the range [3, 50].
     The length of board[i] will be in the range [3, 50].
     Each board[i][j] will initially start as an integer in the range [1, 2000].
 */
public class CandyCrush_723 {

	public static int[][] candyCrush(int[][] board) {

        boolean isCrushable = true;
        int m = board.length;
        int n = board[0].length;

        while (isCrushable) {
            isCrushable = false;

            // check every row
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n - 2; j++) {
                    int val = Math.abs(board[i][j]);
                    if (val != 0 && Math.abs(board[i][j + 1]) == val
                        && Math.abs(board[i][j + 2]) == val) {

                        board[i][j] = board[i][j + 1] = board[i][j + 2] = -val; // mark as negative
                        isCrushable = true;
                    }
                }
            }

            // check every column
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m - 2; j++) {
                    int val = Math.abs(board[j][i]);
                    if (val != 0 && Math.abs(board[j + 1][i]) == val
                        && Math.abs(board[j + 2][i]) == val) {

                        board[j][i] = board[j + 1][i] = board[j + 2][i] = -val;
                        isCrushable = true;
                    }
                }
            }

            // crushing, start from left-bottom
            for (int col = 0; col < n; col++) { // start from each col, because after crash it will fall down
                int wr = m - 1;
                for (int row = m - 1; row >= 0; row--) {
                    if (board[row][col] > 0)
                        //board[wr--][col] = board[row][col];
                    	wr--;
                }
                while (wr >= 0) { // wipe the rest at higher band of each col
                    board[wr--][col] = 0;
                }
            }
        }

        return board;
    }
	public static void main(String args[]) {
		int[][] arr = {{1,1,1},{1,2,3},{1,4,5}};
		int[][] output = null;
		output = arr;
		for(int i=0;i<output.length;i++) {
			for(int j=0;j<output[0].length;j++) {
				System.out.print(output[i][j] +" ");
			}System.out.println();
		}
		System.out.println("---------");
		output = candyCrush(arr);
		for(int i=0;i<output.length;i++) {
			for(int j=0;j<output[0].length;j++) {
				System.out.print(output[i][j] +" ");
			}System.out.println();
		}
	}
}
