package basic.dynamicProgramming.knapsack;

public class CountNumberOfSubsetWithGivenDifference {
	//Say given diff is 1 now we need to find out how many ways are possible 
	//to divide the array in subset so that diff is equal to given value
	//{1,1,2},{3}
	//{1,2},{1,3}
	//{1,3},{1,2} so for this case answer should be 3
	public static void main(String args[]) {
		int set[] = { 1,1,2,3 };//{3,4} , {4,2,1}, {7}
		int diff = 1;
		//s1-s2 = diff
		//s1+s2 = sumOfArr
		//s1 = (diff+sumOfArr)/2; now diff is given to us and sumOfArr we can find out , so we can fid the s1 . 
		//now count of such s1 we can find out from CountOfSubSetSum
		int sum = (1+7)/2;
		int n = set.length;
		CountOfSubSetSum x = new CountOfSubSetSum();
		System.out.println("Found a subset" + " with given sum = "+x.isSubsetSum(set, n, sum));
	}
	
}
