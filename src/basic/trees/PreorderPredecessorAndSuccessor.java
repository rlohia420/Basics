package basic.trees;

public class PreorderPredecessorAndSuccessor {
	static class Node {
		Node left, right, parent;
		int value;
	}

	// Utility function to create a new node with
	// given value.
	static Node newNode(int value) {
		Node temp = new Node();
		temp.left = null;
		temp.right = null;
		temp.parent = null;
		temp.value = value;
		return temp;
	}

	static Node preorderPredecessor(Node root, Node n) {
		// Root has no predecessor in preorder
		// traversal
		if (n == root)
			return null;

		// If given node is left child of its
		// parent or parent's left is empty, then
		// parent is Preorder Predecessor.
		Node parent = n.parent;
		if (parent.left == null || parent.left == n)
			return parent;

		// In all other cases, find the rightmost
		// child in left subtree of parent.
		Node curr = parent.left;
		while (curr.right != null)
			curr = curr.right;

		return curr;
	}

	static Node preorderSuccessor(Node root, Node n) {
		// If left child exists, then it is preorder
		// successor.
		if (n.left != null)
			return n.left;

		// If left child does not exist and right child
		// exists, then it is preorder successor.
		if (n.right != null)
			return n.right;

		// If left child does not exist, then
		// travel up (using parent pointers)
		// until we reach a node which is left
		// child of its parent.
		Node curr = n, parent = curr.parent;
		while (parent != null && parent.right == curr) {
			curr = curr.parent;
			parent = parent.parent;
		}

		// If we reached root, then the given
		// node has no preorder successor
		if (parent == null)
			return null;

		return parent.right;
	}

	// Driver code
	public static void main(String[] args) {
		Node root = newNode(20);
		root.parent = null;
		root.left = newNode(10);
		root.left.parent = root;
		root.left.left = newNode(4);
		root.left.left.parent = root.left;
		root.left.right = newNode(18);
		root.left.right.parent = root.left;
		root.right = newNode(26);
		root.right.parent = root;
		root.right.left = newNode(24);
		root.right.left.parent = root.right;
		root.right.right = newNode(27);
		root.right.right.parent = root.right;
		root.left.right.left = newNode(14);
		root.left.right.left.parent = root.left.right;
		root.left.right.left.left = newNode(13);
		root.left.right.left.left.parent = root.left.right.left;
		root.left.right.left.right = newNode(15);
		root.left.right.left.right.parent = root.left.right.left;
		root.left.right.right = newNode(19);
		root.left.right.right.parent = root.left.right;

		Node res = preorderPredecessor(root, root.left.right.right);
		if (res != null)
			System.out.println("Preorder predecessor of " + root.left.right.right.value + " is " + res.value);
		else
			System.out.println("Preorder predecessor of " + root.left.right.right.value + " is null");

		Node res1 = preorderSuccessor(root, root.left.right.right);

		if (res1 != null) {
			System.out.printf("Preorder successor of %d is %d\n", root.left.right.right.value, res1.value);
		} else {
			System.out.printf("Preorder successor of %d is null\n", root.left.right.right.value);
		}
	}
}
