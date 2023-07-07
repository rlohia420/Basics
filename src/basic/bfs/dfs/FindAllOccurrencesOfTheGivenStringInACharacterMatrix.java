package basic.bfs.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FindAllOccurrencesOfTheGivenStringInACharacterMatrix {
//https://www.techiedelight.com/find-occurrences-given-string-character-matrix/
	// Below arrays detail all eight possible movements from a cell
	private static final int[] row = { -1, -1, -1, 0, 0, 1, 1, 1 };
	private static final int[] col = { -1, 0, 1, -1, 1, -1, 0, 1 };

	// Function to check if it is possible to go to position next
	// from the current position. The function returns false if next is
	// not in a valid position, or it is already visited
	public static boolean isValid(Node next, List<Node> path, int M, int N) {
		return (next.x >= 0 && next.x < M) && (next.y >= 0 && next.y < N) && !path.contains(next);
	}

	public static void DFS(char[][] mat, String word, Node next, List<Node> path, int index) {
		int i = next.x;
		int j = next.y;

		// return if characters don't match
		if (mat[i][j] != word.charAt(index)) {
			return;
		}

		// include the current cell in the path
		path.add(Node.of(i, j));

		// if all words are matched, print the result and return
		if (index == word.length() - 1) {
			System.out.println(path);
		} else {
			// check all eight possible movements from the current cell
			// and recur for each valid movement
			for (int k = 0; k < row.length; k++) {
				// calculate the next position
				next = Node.of(i + row[k], j + col[k]);

				// check if it is possible to go to the next position
				// from the current position
				if (isValid(next, path, mat.length, mat[0].length)) {
					DFS(mat, word, next, path, index + 1);
				}
			}
		}

		// backtrack: remove the current cell from the path
		path.remove(path.size() - 1);
	}

	public static void findAllOccurences(char[][] mat, String word) {
		// base case
		if (mat == null || mat.length == 0 || word == null) {
			return;
		}

		List<Node> path = new ArrayList<>();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				DFS(mat, word, Node.of(i, j), path, 0);
			}
		}
	}

	public static void main(String[] args) {
		char mat[][] = { "DEMXB".toCharArray(), "AOEPE".toCharArray(), "DDCOD".toCharArray(), "EBEDS".toCharArray(),
				"CPYEN".toCharArray() };

		String word = "CODE";

		findAllOccurences(mat, word);
	}
}

// Node class
class Node {
	public int x, y;

	private Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public static Node of(int x, int y) {
		return new Node(x, y);
	}

	@Override
	public boolean equals(Object o) {
		Node node = (Node) o;
		return x == node.x && y == node.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public String toString() {
		return ("(" + x + ", " + y + ")");
	}
}
