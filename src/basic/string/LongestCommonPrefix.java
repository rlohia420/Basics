package basic.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefix {
	public static String longestCommonPrefix(String[] arr, int n) {
		String result = "";
		Map<Character, Integer> map = new HashMap<>();
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			min = Math.min(min, arr[i].length());
		}
		for (int j = 0; j < min; j++) {
			for (int i = 0; i < n; i++) {
				char[] a = arr[i].toCharArray();
				if (map.containsKey(a[j])) {
					map.put(a[j], map.get(a[j]) + 1);
				} else {
					map.put(a[j], 1);
				}
				if (i == n - 1 && map.get(a[j]) == n) {
					result += a[j];
				}
			}
			map.clear();
		}
		System.out.println(arr[0].indexOf(result));
		return arr[0].indexOf(result) == 0 ? result : "";
	}

	public static void main(String args[]) {
		// String[] arr = {"kimrekacsf", "kimrettrwa", "kimreeybfg", "timrewwmnr",
		// "kimretjxjl" ,"kimrejecjw"};
		// System.out.println(longestCommonPrefix(arr,arr.length));
		String[] input = { "geeksforgeeks", "geeks", "geek", "geezer", "gez" };
		System.out.println(longestCommonPrefix(input));
	}

	public static String longestCommonPrefix(String[] a) {
		int size = a.length;

		/* if size is 0, return empty string */
		if (size == 0)
			return "";

		if (size == 1)
			return a[0];

		/* sort the array of strings */
		Arrays.sort(a);

		/* find the minimum length from first and last string */
		int end = Math.min(a[0].length(), a[size - 1].length());

		/*
		 * find the common prefix between the first and last string
		 */
		int i = 0;
		while (i < end && a[0].charAt(i) == a[size - 1].charAt(i))
			i++;

		String pre = a[0].substring(0, i);
		return pre;
	}

	// 3rd approach - divide and conquer:
	static String commonPrefixUtil(String str1, String str2) {
		String result = "";
		int n1 = str1.length(), n2 = str2.length();

		for (int i = 0, j = 0; i <= n1 - 1 && j <= n2 - 1; i++, j++) {
			if (str1.charAt(i) != str2.charAt(j)) {
				break;
			}
			result += str1.charAt(i);
		}
		return (result);
	}

	// A Divide and Conquer based function to find the
	// longest common prefix. This is similar to the
	// merge sort technique
	static String commonPrefix(String arr[], int low, int high) {
		if (low == high) {
			return (arr[low]);
		}

		if (high > low) {
			// Same as (low + high)/2, but avoids overflow for
			// large low and high
			int mid = low + (high - low) / 2;

			String str1 = commonPrefix(arr, low, mid);
			String str2 = commonPrefix(arr, mid + 1, high);

			return (commonPrefixUtil(str1, str2));
		}
		return null;
	}
}
