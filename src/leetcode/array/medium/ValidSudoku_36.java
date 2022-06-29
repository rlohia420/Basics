package leetcode.array.medium;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku_36 {
	 public static boolean isValidSudoku(char[][] board) {
	        Set<Character> set = new HashSet<Character>();
	        for (int i = 0;i < board.length; i++) {
	            set.clear();
	            for (int j = 0; j < board.length; j++) {
	                if (process(set, board[i][j]) == false)
	                    return false;
	            }
	        }
	        for (int j = 0;j < board.length; j++) {
	            set.clear();
	            for (int i = 0; i < board.length; i++) {
	                if (process(set, board[i][j]) == false)
	                    return false;
	            }
	        }
	        for(int i = 0; i<9; i+= 3){
	            for(int j = 0; j<9; j+= 3){
	                set.clear();
	                for(int k = 0; k<9; k++){
	                    if(!process(set, board[i + k/3][ j + k%3]))
	                        return false;                   
	                }
	            }
	        }

	        return true;
	    }
	    private static boolean process(Set<Character> set, char c) {
	        return c=='.' || set.add(c);
	    }

	    public static void main(String  args[]) {
	    	char[][] board ={{'5','3','.','.','7','.','.','.','.'}
	    					,{'6','.','.','1','9','5','.','.','.'}
	    					,{'.','9','8','.','.','.','.','6','.'}
	    					,{'8','.','.','.','6','.','.','.','3'}
	    					,{'4','.','.','8','.','3','.','.','1'}
	    					,{'7','.','.','.','2','.','.','.','6'}
	    					,{'.','6','.','.','.','.','2','8','.'}
	    					,{'.','.','.','4','1','9','.','.','5'}
	    					,{'.','.','.','.','8','.','.','7','9'}};
	    	System.out.println(isValidSudoku(board));
	    }
}
