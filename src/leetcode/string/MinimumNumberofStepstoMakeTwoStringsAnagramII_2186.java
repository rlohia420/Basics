package leetcode.string;

public class MinimumNumberofStepstoMakeTwoStringsAnagramII_2186 {
	public static int minSteps(String s, String t) {
		int[] freq = new int[26];
		for (int i = 0; i < s.length(); i++) {
			freq[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < t.length(); i++) {
			freq[t.charAt(i) - 'a']--;
		}
		int count = 0;
		for (int i = 0; i < 26; i++) {
			count += Math.abs(freq[i]);
		}
		return count;
	}

	public static void main(String args[]) {
		String s = "leetcode", t = "coats";
		// s = l-1, e-3 , t-1 , c-1 , o-1, d-1 e-1
		// t = c-1 , o-1 , a-1 , t-1 ,s-1
		System.out.println(minSteps(s, t));
	}
}
