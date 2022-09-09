package basic.string;

import java.util.HashSet;
import java.util.Set;

public class PalindromicSubstrings {

	public static void main(String args[]) {
		Set<String> pallinDrome = new HashSet<>();
		String str = "abcbc";
		int n = str.length();
		for(int i=0;i<=n;i++) {
			for(int j=i+1;j<=n;j++) {
				if(isPallindrom(str.substring(i,j))) {
					System.out.println(str.substring(i,j));
					pallinDrome.add(str.substring(i,j));
				}
			}
		}
		System.out.println(pallinDrome.size());
	}
	private static boolean isPallindrom(String s) {
		//System.out.println(s);
		if(s.isEmpty()) {
			return true;
		}else {
			StringBuffer sbr = new StringBuffer(s);
			return s.equals(new String(sbr.reverse()));
		}
	}
	private static boolean isPallindromOther(String str) {
		String reverse ="";
		for(int i=str.length()-1;i>=0;i--) {
			reverse = reverse+str.charAt(i);
		}
		return reverse.equals(str);
	}
}
