package leetcode.problems.houseRobber;

public class SuperEggDrop_887 {
	 public int superEggDrop(int k, int n) {
	        //dp[i][j] stores maximum number of floors we can check if we have j eggs and i moves.
	        int[][] dp = new int[n + 1][k + 1];
	        int moves = 0;
	        
	        //Loop till max floors we can check is less than n.
	        while (dp[moves][k] < n) {
	            moves++;
	            //For k eggs, find the minimum number of moves needed to find threshold floor.
	            //dp[moves - 1][egg - 1] : Egg breaks
	            //dp[moves - 1][egg] : Egg doesn't break
	            //Do +1 for the floor we have checked.
	            for (int egg = 1; egg <= k; egg++) {
	                dp[moves][egg] = dp[moves - 1][egg - 1] + 1 + dp[moves - 1][egg];
	            }
	        }
	        
	        //After the above loop, moves contains minimum number of moves that we need to determine 
			//with certainty what the value of f(threshold floor) is.
	        return moves;
	    }
}
