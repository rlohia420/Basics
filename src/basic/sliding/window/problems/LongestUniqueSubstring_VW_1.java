package basic.sliding.window.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestUniqueSubstring_VW_1 {
	public static int longestUniqueSubsttr(String str) {
		if (str.isEmpty()) {
			return 0;
		} else if (str.length() == 1) {
			return 1;
		}
		int size = str.length();
		int i=0,j=0,max=0;
		char[] c = str.toCharArray();
		Set<Character> set = new HashSet<>();
		while(j<size) {
			if(!set.contains(c[j])) {
				set.add(c[j++]);
				max = Math.max(set.size(), max);
			}else {
				set.remove(c[i++]);
			}
		}
		return max;
	}
	public static int longest(String str) {
		int i=0,j=0;
		int max = Integer.MIN_VALUE;
		int size = str.length();
		Map<Character,Integer> map = new HashMap<>();
		while(j<size) {
			if(map.containsKey(str.charAt(j))) {
				map.put(str.charAt(j), map.get(str.charAt(i))+1);
			}else {
				map.put(str.charAt(j), 1);
			}
			if(map.size() > (j-i+1)) {
				j++;
			}else if(map.size()==(j-i+1)) {
				max = Math.max(max, j-i+1);
				j++;
			}else if(map.size() < (j-i+1)) {
				while(map.size() < (j-i+1)) {
					map.put(str.charAt(i),map.get(str.charAt(i))-1);
					if(map.get(str.charAt(i))==0) {
						map.remove(str.charAt(i));
					}
					i++;
				}
				j++;
			}
		}
		return max;
	}
	public static void main(String[] args) {
		String str = "geeksforgeeks";
		String s1 = "ababcabab";
		String s2 = "bbbbb";
		String s3 = "pwwkew";
		//String str = "pwwkew";//"aabacbebebe";
		System.out.println("The input string is " + str);
		int len = longestUniqueSubsttr(str);
		System.out.println(str +" = " + len);
		System.out.println("ababcabab = "+ longestUniqueSubsttr("ababcabab"));
		System.out.println("bbbbb = "+longest("bbbbb"));
		System.out.println("pwwkew = "+longest("pwwkew"));
	}
}
