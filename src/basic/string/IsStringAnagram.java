package basic.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsStringAnagram {

	public static void main(String args[]) {
		/*System.out.println("When string are equal irrespective of character position");
		System.out.println(isAnagram("CAT", "TAC"));
		
		System.out.println(isAnagramUsingMap("CAT","TAC"));
		*/subString("abc");
	}

	public static boolean isAnagram(String a, String b) {
		char[] word1 = a.toLowerCase().replaceAll("[\\s]", "").toCharArray();
		char[] word2 = b.toLowerCase().replaceAll("[\\s]", "").toCharArray();
		Arrays.sort(word1);
		Arrays.sort(word2);
		System.out.println(word1);
		System.out.println("======");
		System.out.println(word2);
		return (Arrays.equals(word1, word2));
	}

	public static boolean isAnagramUsingMap(String a, String b) {
		boolean status = true;
		if (a.length() != b.length())
			status = false;
		else {
			Map<Character, Integer> map = new HashMap<>();
			for (int i = 0; i < a.length(); i++) {
				char key = a.charAt(i);
				if (map.containsKey(key)) {
					map.put(key,map.get(key)+1);
				}else {
				map.put(key, 1);}
			}
			for (int i = 0; i < a.length(); i++) {
				char key = b.charAt(i);
				key=b.charAt(i);
				if(map.containsKey(key)) {
					map.put(key,map.get(key)-1);
				}else {
				map.put(key,1);}
			}
			for(int value:map.values()) {
				if(value!=0)
				status= false;
			}
		}
		return status;
	}
	
	private static void subString(String str) {
		for(int i=0;i<=str.length();i++) {
			for(int j=str.length();j>=0;j--) {
				System.out.println(str.substring(i,j));
			}
		}
	}
}
