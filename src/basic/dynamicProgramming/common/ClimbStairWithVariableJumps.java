package basic.dynamicProgramming.common;

/*
 * 1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. You are given n numbers, where ith element's value represents - till how far from the step you 
     could jump to in a single move.  
     You can of course jump fewer number of steps in the move.
4. You are required to print the number of different paths via which you can climb to the top.
 */
//https://www.youtube.com/watch?v=uNqoQ0sNZCM&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=3
public class ClimbStairWithVariableJumps {
	public static void main(String[] args) throws Exception {
	    int n = 6;
	    int[] arr = {3,3,0,2,2,3};
	    
	    int[] dp = new int[n + 1];
	    dp[n] = 1;

//	    for (int i = n - 1; i >= 0; i--) {
//	      for (int j = i + 1; j <= Math.min(n, i + arr[i]); j++) {
//	        dp[i] += dp[j];
//	      }
//	    }
	    for(int i=n-1;i>=0;i--) {
	    	for(int j=1;j<=arr[i] && i+j<dp.length;j++) {
	    		dp[i] =dp[i]+dp[i+j];
	    	}
	    }
	    System.out.println(dp[0]);
	  }
}
