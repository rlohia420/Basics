package basic.dynamicProgramming.bounded.knapsack;

public class CountNumberOfSubsetWithGivenDifference_6 {
	//Say given diff is 1 now we need to find out how many ways are possible 
	//to divide the array in subset so that diff is equal to given value
	//{1,1,2},{3}
	//{1,2},{1,3}
	//{1,3},{1,2} so for this case answer should be 3
	
	
	private static int CountSubsetsWithSum(int arr[], int n, int sum) {
		int t[][] = new int[n + 1][sum + 1]; // DP - matrix
		// initialization
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {
				if (i == 0)
					t[i][j] = 0;
				if (j == 0)
					t[i][j] = 1;
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (arr[i - 1] <= j)
					t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
				else
					t[i][j] = t[i - 1][j];
			}
		}

		return t[n][sum];
	}
	
	
	private static int CountSubsetsWithDiff(int arr[], int n, int diff) {
		int sumOfArray = 0;
		for (int i = 0; i < n; i++)
			sumOfArray += arr[i];

		if ((sumOfArray + diff) % 2 != 0)
			return 0;
		else
			return CountSubsetsWithSum(arr, n, (sumOfArray + diff) / 2);
	}

	public static void main(String args[]) {
		int set[] = { 3, 7, 2,2,1};// { 3,2,2 }, {7,1} AND {3,2,2,1} , {7};//
		int diff = 1;
		System.out.println(CountSubsetsWithDiff(set,set.length,diff));
	}
	
	/*public static void main(String args[]) {
		int set[] = { 3, 34, 4, 12, 7, 2,1 };// { 1,1,2,3 };//
		int diff = 1;
		//s1-s2 = diff
		//s1+s2 = sumOfArr
		//s1 = (diff+sumOfArr)/2; now diff is given to us and sumOfArr we can find out , so we can fid the s1 . 
		//now count of such s1 we can find out from CountOfSubSetSum
		int sum = (1+ 3+ 34+ 4+ 12+ 7+ 2+1)/2;
		System.out.println("sum = "+sum);
		int n = set.length;
		CountOfSubSetSum_4 x = new CountOfSubSetSum_4();
		System.out.println("Found a subset" + " with given sum = "+x.subsetSum(set, n, sum));
	}*/
	
}
