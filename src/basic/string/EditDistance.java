package basic.string;

public class EditDistance {
	public int minDistance(String word1, String word2) {

	    //distance is every + 1 but, word[i] == word[j]  => 0
	    //distace Min(dp[i][j-1] + 1, dp[i-1][j] + 1, dp[i-1][j-1] + cost)
		
	    //explain
	    /*
	            0    r                   o                   s
	        0   0    1                   2                   3
	        h   1    1(1+1, 1+1, 0+1)    2(1+1, 2+1, 1+1)    3(2+1, 3+1, 2+1)
	        o   2    2(1+1, 2+1, 1+1)    1(2+1, 2+1, 1+0)    2(1+1, 3+1, 2+1)
	        r   3    2(3+1, 2+1, 2+0)    2(2+1, 1+1, 2+1)    2(2+1, 2+1, 1+1)
	        s   4    3(4+1, 2+1, 3+1)    3(3+1, 2+1, 2+1)    2(3+1, 2+1, 2+0)
	        e   5    4(5+1, 3+1, 4+1)    4(4+1, 3+1, 3+1)    3(4+1, 2+1, 3+1)
	    */
	    
	    int[][] dp = new int[word1.length() + 1][word2.length() + 1];
	    
	    //min distance setting
	    for(int i = 0; i < dp.length; i++) {
	        dp[i][0] = i;
	    }
	    
	    for(int i = 1; i < dp[0].length; i++) {
	        dp[0][i] = i;
	    }

	    for(int i = 1; i <= word1.length(); i++) {
	        for(int j = 1; j <= word2.length(); j++) {
	            
	            int dis = 1;
	            
	            if(word1.charAt(i-1) == word2.charAt(j-1)) dis = 0;

	            dp[i][j] = Math.min(Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1), dp[i-1][j-1] + dis);
	        }
	    }
	    
	return dp[word1.length()][word2.length()];
	}
}
