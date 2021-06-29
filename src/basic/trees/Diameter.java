package basic.trees;

public class Diameter {
	/*
	 * Diameter is the longest path between two nodes in tree
	 */
	static int ans = 0;

	public int diameter(BinaryTree.Node node) {
		ans = 1;
		depth(node);
		return ans - 1;
	}

	private static int depth(BinaryTree.Node node) {
		if (node == null)
			return 0;
		int l = depth(node.left);
		int r = depth(node.right);
		ans = Math.max(ans, l + r + 1);
		return Math.max(l, r) + 1;
	}
}
