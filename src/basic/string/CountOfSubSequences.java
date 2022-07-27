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

	private static void dfs(String path, String left) {
		if (path.length() > 0)
			paths.add(path);
		for (int i = 0; i < left.length(); i++) {
			String before = left.substring(0, i);
			String after = left.substring(i + 1, left.length());
			dfs(path + left.charAt(i), before + after);
		}
	}
	public static void main(String args[]) {
		String tiles = "ABC";
		System.out.println(numTilePossibilities(tiles));
	}
}
