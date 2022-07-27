package basic.dynamicProgramming.lcs;

public class PrintLCSubString_6 {

	public static String longestCommonSubString(char[] X, char[] Y, int m, int n) {
		int[][] LCSuff = new int[m+1][n+1];
		int Endindex =0;
		int maxLen=0;
		 for (int i = 0; i <= m; i++) {
		        for (int j = 0; j <= n; j++) {
		            if (i == 0 || j == 0)
		                LCSuff[i][j] = 0;
		 
		            else if (X[i - 1] == Y[j - 1]) {
		                LCSuff[i][j] = LCSuff[i - 1][j - 1] + 1;
		                if (maxLen < LCSuff[i][j]) {
		                    maxLen = LCSuff[i][j];
		                    Endindex=i;
		                }
		            }
		            else
		                LCSuff[i][j] = 0;
		        }
		    }
		 String x = new String(X);
			return x.substring(Endindex-maxLen,Endindex);
	}
	
	public static void main(String args[]) {
		//String x = "abcgefgh";
		//String y = "abcxefy";
		String x="abababced";
		String y="abcabced";
		int m = x.length();
		int n = y.length();
		System.out.println(longestCommonSubString(x.toCharArray(), y.toCharArray(), m, n));
	}
}
