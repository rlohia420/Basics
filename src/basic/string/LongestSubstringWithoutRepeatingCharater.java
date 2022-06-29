package basic.string;

import java.util.HashMap;
import java.util.Map;

//TODO: check this
public class LongestSubstringWithoutRepeatingCharater {

	public static void main(String args[]) {
		String s1 = "ababcabab";
		String s2 = "bbbbb";
		String s3 = "pwwkew";
		System.out.println("s1 -ababcabab  output = "+longest(s1));
		System.out.println("s2 - bbbbb output = "+longest(s2));
		System.out.println("s3 - pwwkew output = "+longest(s3));
	}
	public static int longest(String str) {
		String result ="";
		char[] charA = str.toCharArray();
		Map<Character,Integer> map = new HashMap<>();
		int j=0;
		for(int i=0;i<charA.length;i++) {
			Character c = charA[i];
			if(map.containsKey(c)) {
				j = Math.max(map.get(c)+1, j);
			}
			if(result.length() < i-j+1) {
				result = str.substring(j,i+1);
			}
			map.put(c,j);
		}
		return result.length();
	}
}
