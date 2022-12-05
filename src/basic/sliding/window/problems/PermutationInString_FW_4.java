package basic.sliding.window.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PermutationInString_FW_4 {
	public static boolean checkInclusion(String s1, String s2) {
		int i=0,j=0;
		int k = s1.length();
		boolean result = false;
		while(j<s2.length() && !result) {
			if(j-i+1 <k) {
				j++;
			}else if(j-i+1 == k) {
				result = isAnagram(s1,s2.substring(i,j+1));
				i++;j++;
			}
		}
		return result;
	}
	private static boolean isAnagram(String a, String b) {
		if(a.length()!=b.length()) {
			return false;
		}else {
			char[] c1 = a.toLowerCase().toCharArray();
			char[] c2 = b.toLowerCase().toCharArray();
			Arrays.sort(c1);
			Arrays.sort(c2);
			return Arrays.equals(c1, c2);
		}
	}
	private static boolean isPermutation(String s1 , String s2) {
		Map<Character,Integer> map = new HashMap<>();
		for(int i=0;i<s1.length();i++) {
			Character a = s1.charAt(i);
			if(map.containsKey(a)) {
				map.put(a, map.get(a)+1);
			}else {
				map.put(a, 1);
			}
			Character b = s2.charAt(i);
			if(map.containsKey(b)) {
				map.put(b , map.get(b)-1);
			}else {
				map.put(b, -1);
			}
		}
		boolean bool= true;
		for(Entry<Character,Integer> ent:map.entrySet()) {
			if(ent.getValue()!=0) {
				bool = false;
				break;
			}
		}
		return bool;
	}
	public static void main(String args[]) {
		String s1 = "bd1", s2 = "ei1dbaooo";
		System.out.print(checkInclusion(s1,s2));
	}
}
