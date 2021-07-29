package basic.dynamicProgramming.knapsack;

public class EqualSumPartition {
	public static void main(String args[]) {
		int set[] = { 1,5,5,11 };
		if (isEqualSumPartition(set) == true)
			System.out.println("Found equal sum partion");
		else
			System.out.println("No equal sum partition");
	}
	public static boolean isEqualSumPartition(int set[]){
		int sum=0;
		for(int i=0;i<set.length;i++) {
			sum=sum+set[i];
		}
		if(sum%2==0) {
			return isSubsetSum(set,set.length,sum/2);
		}else {
			return false;
		}
		
	}
	static boolean isSubsetSum(int set[], int n, int sum) {
		boolean subset[][] = new boolean[sum + 1][n + 1];

		for (int i = 0; i <= n; i++)
			subset[0][i] = true;

		for (int i = 1; i <= sum; i++)
			subset[i][0] = false;

		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= n; j++) {
				subset[i][j] = subset[i][j - 1];
				if (i >= set[j - 1])
					subset[i][j] = subset[i][j] || subset[i - set[j - 1]][j - 1];
			}
		}
		return subset[sum][n];
	}
}
