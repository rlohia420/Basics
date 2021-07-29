package basic.dynamicProgramming.knapsack;

public class maxSubArray {

	public static int maxSubArray(int[] nums) {
		int sum =0 , maxSum = Integer.MIN_VALUE;
		for(int num:nums) {
			sum = Math.max(sum, 0)+num;
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}
	public static void main(String args[]) {
		int[] nums = {-2,1,-1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}
}
