package basic.dynamicProgramming.unbounded.knapsack;

//https://www.youtube.com/watch?v=aycn9KO8_Ls&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=13
//https://www.youtube.com/watch?v=SZqAQLjDsag&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=14
public class RodCutting_1 {
	static int rodCutting(int N, int rodLength[], int price[], int n) {
		int i, j=0;
		int dp[][] = new int[n + 1][N + 1];
		for (i = 0; i <= n; i++) {
			for (j = 0; j <= N; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else if (rodLength[i - 1] <= j)
					dp[i][j] = Math.max(price[i - 1] + dp[i][j - rodLength[i - 1]],
										dp[i - 1][j]);
				else
					dp[i][j] = dp[i - 1][j];
			}
		}

		return dp[n][N];
	}

	public static void main(String args[]) {
		//int[] price = { 60, 100,200, 120};
		//int[] length = {50,10,20,30};
		//int desiredLength = 50;
		int[] length={1,2,3,4,5,6,7,8};
		int[] price ={3,5,8,9,10,17,17,20};
		int desiredLength =8;
		System.out.println(rodCutting(desiredLength,length,price,price.length));
	}
}
