package leetcode.string;

public class RemoveAllOccurrencesOfASubstring_1910 {

	public static void main(String asrgs[]) {
		String s = "daabcbaabcbc", part = "abc";
		System.out.println(removeOccurrences(s,part));
	}
	public static String removeOccurrences(String s, String part) {
		if(!s.contains(part)) {
			return s;
		}else {
			return removeOccurrences(s.replace(part,""),part);
		}
		//return s;
	}
	
}
