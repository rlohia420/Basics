package basic.sliding.window.problems;

//Using sliding window
public class NumberOfSubArraysAfSizeKAndAverageGreaterThanOrEqualToThreshold_FW_6 {
	/*
	 * Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4 Output: 3 Explanation:
	 * Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 respectively.
	 * All other sub-arrays of size 3 have averages less than 4 (the threshold).
	 */

	public static int numOfSubarrays(int[] arr, int k, int threshold) {
		int i=0; int j=0;
		int sum = 0;
		int count=0;
		
		while(j<arr.length) {
			sum = sum + arr[j];
			
			if((j-i+1)< k) {
				j++;
			}else if((j-i+1) == k) {
				int average = sum/k;
				if(average>=threshold) {
					count++;
				}
				sum = sum-arr[i];
				j++; i++;
			}
		}
		return  count;
	}
	
	public static void main(String args[]) {
		int[] arr = {11,13,17,23,29,31,7,5,2,3}; int  k = 3, threshold = 5;
					// {41,53,69,83,67,43,14,10}  => {13,17,23,27,22,14,4,3}
		System.out.println(numOfSubarrays(arr,k,threshold));
	}
	
}
