package basic.bfs.dfs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class ChessKnightProblemFindTheShortestPathFromSourceToDestination {
//https://www.techiedelight.com/chess-knight-problem-find-shortest-path-source-destination/
	// A queue node used in BFS
	// Below arrays detail all eight possible movements for a knight
	private static int[] row = { 2, 2, -2, -2, 1, 1, -1, -1 };
	private static int[] col = { -1, 1, 1, -1, 2, -2, 2, -2 };

	// Check if (x, y) is valid chessboard coordinates.
	// Note that a knight cannot go out of the chessboard
	private static boolean isValid(int x, int y, int N) {
		return (x >= 0 && x < N) && (y >= 0 && y < N);
	}

	// Find the minimum number of steps taken by the knight
	// from the source to reach the destination using BFS
	public static int findShortestDistance(Node1 src, Node1 dest, int N) {
		// set to check if the matrix cell is visited before or not
		Set<Node1> visited = new HashSet<>();

		// create a queue and enqueue the first node
		Queue<Node1> q = new ArrayDeque<>();
		q.add(src);

		// loop till queue is empty
		while (!q.isEmpty()) {
			// dequeue front node and process it
			Node1 node = q.poll();

			int x = node.x;
			int y = node.y;
			int dist = node.dist;

			// if the destination is reached, return distance
			if (x == dest.x && y == dest.y) {
				return dist;
			}

			// skip if the location is visited before
			if (!visited.contains(node)) {
				// mark the current node as visited
				visited.add(node);

				// check for all eight possible movements for a knight
				// and enqueue each valid movement
				for (int i = 0; i < row.length; i++) {
					// get the knight's valid position from the current position on
					// the chessboard and enqueue it with +1 distance
					int x1 = x + row[i];
					int y1 = y + col[i];

					if (isValid(x1, y1, N)) {
						q.add(new Node1(x1, y1, dist + 1));
					}
				}
			}
		}

		// return infinity if the path is not possible
		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) {
		// N x N matrix
		int N = 8;

		// source coordinates
		Node1 src = new Node1(0, 7);

		// destination coordinates
		Node1 dest = new Node1(7, 0);

		System.out.println("The minimum number of steps required is " + findShortestDistance(src, dest, N));
	}

}

class Node1 {
	// (x, y) represents chessboard coordinates
	// `dist` represents its minimum distance from the source
	int x, y, dist;

	public Node1(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Node1(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}

	// As we are using the class object as a key in a `HashMap`,
	// we need to implement `hashCode()` and `equals()`

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Node1 node = (Node1) o;
		return x == node.x && y == node.y && dist == node.dist;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y, dist);
	}
}
