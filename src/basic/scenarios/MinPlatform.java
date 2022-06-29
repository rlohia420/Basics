package basic.scenarios;

import java.util.Arrays;

public class MinPlatform {

	public static int findPlatform(int[] arr, int[] dep, int n) {
		Arrays.sort(arr);
		Arrays.sort(dep);
		int platformNeeded = 1;
		int result = 1;
		int i = 1, j = 0;
		while (i < n && j < n) {
			if (arr[i] <= dep[j]) {
				platformNeeded++;
				i++;
			}  else if (arr[i] > dep[j]) {
				platformNeeded--;
				j++;
			}
			result = Math.max(result, platformNeeded);

		}
		return result;

	}

	public static void main(String args[]) {
		int[] arr = { 200, 215, 230, 430, 500 };
		int[] dep = { 230, 250, 400, 500, 600 };
		System.out.println(findPlatform(arr, dep, 5));
	}
}
