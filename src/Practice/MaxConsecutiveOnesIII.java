package Practice;

public class MaxConsecutiveOnesIII {
	/*
	 * Given a binary array nums and an integer k, return the maximum number of
	 * consecutive 1's in the array if you can flip at most k 0's. Input: nums =
	 * [1,1,1,0,0,0,1,1,1,1,0], k = 2 Output: 6 Explanation: [1,1,1,0,0,1,1,1,1,1,1]
	 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
	 */
	public static int longestOnes(int[] nums, int k) {
		int j = 0;
		int i = 0;
		int count = 0;
		int maxi = 0;
		while (j != nums.length && i <= j) {
			while (j != nums.length && count <= k) {
				if (nums[j] == 0)
					count++;
				if (count <= k) {
					int window = j - i + 1;
					maxi = Math.max(maxi, window);
				}
				j++;
			}
			while (count > k) {
				if (nums[i] == 0)
					count--;
				i++;
			}

		}
		return maxi;

	}

	public static void main(String args[]) {
		int[] arr = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
		int k = 2;
		System.out.println(longestOnes(arr, k));
	}
}
