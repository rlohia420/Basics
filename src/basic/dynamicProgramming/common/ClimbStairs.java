package basic.dynamicProgramming.common;

/*
 * You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. 
In how many distinct ways can you climb to the top?
 */
public class ClimbStairs {
	 public static int climbIn2Steps(int n) {
	        int[] dp = new int[n+1];
	        return climbIn2Steps(n,dp);
	    }
	 //Method for climbing stairs in 2 steps
	    public static int climbIn2Steps(int n , int[] dp){
	        if(n==1 || n==2){
	            return n;
	        }
	        if(dp[n]!=0){
	            return dp[n];
	        }
	        int c1 = climbIn2Steps(n-1 ,dp);
	        int c2 = climbIn2Steps(n-2,dp);
	        int c = c1+c2;
	        dp[n] = c;
	        return c;
	    }
	    
	    //Method for climbing stairs in 3 steps
	    public static int climbIn3StepsUsingMemo(int n , int[] dp){
	        if(n==0 ){
	            return 1;
	        }else if(n < 0) {
	        	return 0;
	        }
	        else if(dp[n]!=0){
	            return dp[n];
	        }
	        int c1 = climbIn3StepsUsingMemo(n-1 ,dp);
	        int c2 = climbIn3StepsUsingMemo(n-2,dp);
	        int c3 = climbIn3StepsUsingMemo(n-3,dp);
	        int c = c1+c2+c3;
	        dp[n] = c;
	        return c;
	    }
	    
	    public static int climbIn3StepsUsingTabulation(int n) {
	    	int[] dp = new int[n+1];
	    	dp[0]=1;
	    	for(int i=1;i<=n;i++) {
	    		if(i==1) {
	    			dp[i] = dp[i-1];
	    		}else if(i==2) {
	    			dp[i] = dp[i-1] + dp[i-2];
	    		}else
	    			dp[i] = dp[i-1] + dp[i-2]+dp[i-3];
	    	}
	    	return dp[n];
	    }
	    public static int climbIn2StepsUsingTabulation(int n) {
	    	int[] dp = new int[n+1];
	    	dp[0]=1;
	    	for(int i=1;i<=n;i++) {
	    		if(i==1) {
	    			dp[i] = dp[i-1];
	    		}else {
	    			dp[i] = dp[i-1] + dp[i-2];
	    		}
	    	}
	    	return dp[n];
	    }
	    
	    public static int climbIn3Steps(int n) {
	        int[] dp = new int[n+1];
	        return climbIn3StepsUsingMemo(n,dp);
	    }
	    public static void main(String args[]) {
	    	System.out.println("2 steps = " +climbIn2Steps(6));
	    	System.out.println("3 steps using memo = "+climbIn3Steps(10));
	    	System.out.println("3 steps using tabulation "+climbIn3StepsUsingTabulation(10));
	    	System.out.println("2 steps using tabulation "+climbIn2StepsUsingTabulation(6));
	    }
}
