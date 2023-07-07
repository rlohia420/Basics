package basic.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class GroupAnagram {
	public static void main(String[] args) {
		String[] strs = { "eat", "tea", "tan", "ate", "bat", "nat" };
		// o/p - [[tea, ate, eat], [tan, nat], [bat]]
		List<String> list = Arrays.asList(strs);
		List<List<String>> result = group_anagram(list);
		System.out.println(result);
	}


	public static List<List<String>> group_anagram(List<String> list) {
		List<List<String>> result = new ArrayList<>();
		int[] counters = new int[list.size()];
		if (list != null && list.size() == 1) {
			result.add(list);
			return result;
		} else {
			for (int i = 0; i < list.size(); i++) {
				if (counters[i] != 1) {
					List<String> innerListA = new ArrayList<>();
					Set<String> innerList = new HashSet<>();
					innerList.add(list.get(i));
					for (int j = i + 1; j < list.size(); j++) {
						if (isAnagram(list.get(i), list.get(j))) {
							System.out.println("anagram = " + list.get(i) + " - " + list.get(j));
							if (counters[j] != 1) {
								innerList.add(list.get(j));
								counters[j] = 1;
							}
						}
					}

					innerListA.addAll(innerList);
					result.add(innerListA);
				}
			}
		}
		return result;
	}

	private static boolean isAnagram(String s1, String s2) {
		if (s1.length() == s2.length()) {
			char[] c1 = s1.toCharArray();
			char[] c2 = s2.toCharArray();
			Arrays.sort(c1);
			Arrays.sort(c2);
			return (String.valueOf(c1).equals(String.valueOf(c2)));
		} else {
			return false;
		}
	}
}
