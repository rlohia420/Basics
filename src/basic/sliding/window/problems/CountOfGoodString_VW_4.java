package basic.sliding.window.problems;

import java.util.Arrays;

public class CountOfGoodString_VW_4 {

	/*
	 * A string is good if there are no repeated characters. Input: s = "xyzzaz"
	 * Output: 1 Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza",
	 * and "zaz". The only good substring of length 3 is "xyz".
	 */
	public static int countGoodSubstrings(String s) {
		int k = 3;
		int i = 0;
		int j = 0;
		int count = 0;
		while (j < s.length()) {
			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				if (goodString(s.substring(i, j + 1))) {
					count++;
				}
				j++;
				i++;
			}
		}
		return count;

	}

	private static boolean goodString(String str) {
		char[] chArray = str.toCharArray();

		Arrays.sort(chArray);

		for (int i = 0; i < chArray.length - 1; i++) {
			if (chArray[i] != chArray[i + 1])
				continue;
			else
				return false;
		}
		return true;
	}

	public static void main(String args[]) {
		System.out.println(countGoodSubstrings("xyzzaz"));
	}
}
