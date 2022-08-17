package sliding.window.problems;

import java.util.ArrayList;
import java.util.List;

public class LargestSubarrayOfSumK_VW_2 {
//https://www.youtube.com/watch?v=TfQPoaRDeMQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=8
	// this solution is for positive numbers only
	public static void main(String argsp[]) {
		int[] arr = { 4, 2, 1, 1, 1, 2, 1, 3, 5 };
		// int[] arr = { -5, 8, 14, 2, 4, 12 };
		int k = 5;
		List<Integer> list = largestSubAraay(arr, k);
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
	}

	public static List<Integer> largestSubAraay(int[] arr, int k) {
		List<Integer> list = new ArrayList<>();
		int i = 0;
		int j = 0;
		int max = Integer.MIN_VALUE;
		int size = arr.length;
		int sum = 0;
		int startIndex = 0;
		while (j < size) {
			sum = sum + arr[j];
			if (sum == k) {
				max = Math.max(max, j - i + 1);
				startIndex = i;
				sum = sum - arr[i];
				i++;
				j++;
			} else if (sum < k) {
				j++;
			} else if (sum > k) {
				while (sum > k) {
					sum = sum - arr[i];
					i++;
				}
				j++;
			}
		}

		for (int ii = startIndex; ii < startIndex + max; ii++) {
			list.add(arr[ii]);
		}
		return list;
	}
}
