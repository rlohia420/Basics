package basic.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LexicographicRankOfAString {

	static List<String> list = new ArrayList<>();
	public static void perm(String perm, String word) {
		if (word.isEmpty()) {
			list.add(perm);
		} else {
			for (int i = 0; i < word.length(); i++) {
				perm(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));
			}
		}
	}
	public static void main(String args[]) {
		String str ="bca";
		perm("", str);
		Collections.sort(list);
		System.out.println(list);
		System.out.println(list.indexOf(str)+1);
	}
}
