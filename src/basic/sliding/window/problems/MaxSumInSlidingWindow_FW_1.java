package basic.sliding.window.problems;

public class MaxSumInSlidingWindow_FW_1 {

	public static void main(String args[]) {
		 int arr[] = { 1, 4, 2, 10, 2, 3, 1, 5, 20 };
	        int k = 3;
	        int n = arr.length;
	       System.out.println("Max sum in window is :"+maxSum(arr, n, k));
	}
	private static int maxSum(int[] arr, int n , int k) {
		int max= Integer.MIN_VALUE;
		int sum =0;
		int i=0, j=0;
		int size = arr.length;
		while(j<size) {
			sum = sum+arr[j];
			if(j-i+1 < k) {
				j++;
			}
			else if(j-i+1 == k) {
				max = Math.max(max,sum);
				sum = sum - arr[i];
				i++;j++;
			}
		}
		return max;
	}
}
