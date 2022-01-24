package basic.dynamicProgramming.common;
//no. of ways to place 2*1 size
//tiles in 2*n size board.
//Nt corrct
public class TilingProblem {
	public static int getNoOfWays(int n)
	{
	    // Base case
	    if (n == 0)
	        return 0;
	    if (n == 1)
	        return 1;
	 
	    return getNoOfWays(n - 1) + getNoOfWays(n - 2);
	}
	 
	// Driver Function
	public static void main(String args[])
	{
	    System.out.println(getNoOfWays(4));
	    System.out.println(getNoOfWays(3));
	    System.out.println(getNoOfWays(7));
	}
}
