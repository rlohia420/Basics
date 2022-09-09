package basic.string;

import java.util.HashSet;

public class CountOfSubSequences {
	static HashSet<String> paths = new HashSet<>();

	public static int numTilePossibilities(String tiles) {
		if(tiles.length()==1) {
			return 1;
		}
		dfs("", tiles);
		return paths.size();
	}

	private static void dfs(String perm, String word) {
		if (perm.length() > 0) {
			paths.add(perm);
			System.out.println(perm);
		}
		for (int i = 0; i < word.length(); i++) {
			dfs(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));
		}
	}
	public static void main(String args[]) {
		String tiles = "ABC";
		System.out.println(numTilePossibilities(tiles));
	}
}
