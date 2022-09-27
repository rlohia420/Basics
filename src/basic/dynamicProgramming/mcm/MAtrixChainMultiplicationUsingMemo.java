package basic.dynamicProgramming.mcm;

import java.util.Arrays;
//https://www.youtube.com/watch?v=9uUVFNOT3_Y&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=34
public class MAtrixChainMultiplicationUsingMemo {
	 static int[][] dp = new int[100][100];
	static int matrixChainMemoised(int[] p, int i, int j)
	  {
	    if (i >= j) 
	    {
	      return 0;
	    }
	    if (dp[i][j] != -1) 
	    {
	      return dp[i][j];
	    }
	    dp[i][j] = Integer.MAX_VALUE;
	    for (int k = i; k < j; k++) 
	    {
	      dp[i][j] = Math.min(
	        dp[i][j], matrixChainMemoised(p, i, k)
	        + matrixChainMemoised(p, k + 1, j)
	        + p[i - 1] * p[k] * p[j]);
	    }
	    return dp[i][j];
	  }
	 
	  static int MatrixChainOrder(int[] p, int n)
	  {
	    int i = 1, j = n - 1;
	    return matrixChainMemoised(p, i, j);
	  }
	 
	  public static void main (String[] args)
	  {
	 
	    int arr[] = { 40, 20, 30, 10, 30};
	    int n= arr.length;
	 
	    for (int[] row : dp)
	      Arrays.fill(row, -1);
	 
	    System.out.println("Minimum number of multiplications is " + MatrixChainOrder(arr, n));
	  }
}
