package basic.sliding.window.problems;

import java.util.Arrays;

public class OccuranceOfAnagramInString_FW_3 {

	public static void main(String args[]) {
		String s = "abacb";
		String p = "abc";
		anagramOccurance(s, p);
	}

	private static void anagramOccurance(String s, String p) {
		int i = 0, j = 0;
		int k = p.length();
		int size = s.length();
		int count = 0;
		while (j < size) {
			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				if (isAnagram(s.substring(i, j + 1), p)) {
					count++;
				}
				i++;
				j++;
			}
		}
		System.out.println(count);
	}

	private static boolean isAnagram(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		} else {
			char[] c1 = a.toLowerCase().toCharArray();
			char[] c2 = b.toLowerCase().toCharArray();
			Arrays.sort(c1);
			Arrays.sort(c2);
			return Arrays.equals(c1, c2);
		}
	}
}
