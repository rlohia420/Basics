package basic.dynamicProgramming.common;

public class FibnocciSeries {

	public static int fibUsingMemoization(int n, int[] dp) {
		if(n==0 ||n==1) {
			return n;
		}
		if(dp[n]!=0) {
			return dp[n];
		}
		int fibn = fibUsingMemoization(n-1,dp);
		int fibm = fibUsingMemoization(n-2,dp);
		int fib = fibn + fibm;
		dp[n] = fib;
		return fib;
	}
	
	
	public static void main(String args[]) {
		int n=6;
		int[] dp = new int[n+1]; 
		int f = fibUsingMemoization(n,dp);
		System.out.println("fibnocci using memoization = "+ f);
		
	}
}
//0,1,2,3,5,8,13,