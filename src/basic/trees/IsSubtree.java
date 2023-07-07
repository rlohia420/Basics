package basic.trees;

import basic.trees.BinaryTree.Node;

public class IsSubtree {

	boolean areIdentical(Node root1, Node root2) {

		/* base cases */
		if (root1 == null && root2 == null)
			return true;

		if (root1 == null || root2 == null)
			return false;

		/*
		 * Check if the data of both roots is same and data of left and right subtrees
		 * are also same
		 */
		return (root1.data == root2.data && areIdentical(root1.left, root2.left)
				&& areIdentical(root1.right, root2.right));
	}

	/*
	 * This function returns true if S is a subtree of T, otherwise false
	 */
	boolean isSubtree(Node T, Node S) {
		/* base cases */
		if (S == null)
			return true;

		if (T == null)
			return false;

		/* Check the tree with root as current node */
		if (areIdentical(T, S))
			return true;

		/*
		 * If the tree with root as current node doesn't match then try left and right
		 * subtrees one by one
		 */
		return isSubtree(T.left, S) || isSubtree(T.right, S);
	}

	public static void main(String args[]) {
		IsSubtree isSubtree = new IsSubtree();
		// TREE 1
		/*
		 * Construct the following tree 26 / \ 10 3 / \ \ 4 6 3 \ 30
		 */
		
		Node n = new Node(26);
		n.right = new Node(3);
		n.right.right = new Node(3);
		n.left = new Node(10);
		n.left.left = new Node(4);
		n.left.left.right = new Node(30);
		n.left.right = new Node(6);

		// TREE 2
		/*
		 * Construct the following tree 10 / \ 4 6 \ 30
		 */

		Node n1 = new Node(10);
		n1.right = new Node(6);
		n1.left = new Node(4);
		n1.left.right = new Node(30);

		if (isSubtree.isSubtree(n, n1))
			System.out.println("Tree 2 is subtree of Tree 1 ");
		else
			System.out.println("Tree 2 is not a subtree of Tree 1");
	}
}
