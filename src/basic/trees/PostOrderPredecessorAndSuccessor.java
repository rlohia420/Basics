package basic.trees;

public class PostOrderPredecessorAndSuccessor {
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

	static Node postorderSuccessor(Node root, Node n) {
		// Root has no successor in postorder
		// traversal
		if (n == root)
			return null;

		// If given node is right child of its
		// parent or parent's right is empty, then
		// parent is postorder successor.
		Node parent = n.parent;
		if (parent.right == null || parent.right == n)
			return parent;

		// In all other cases, find the leftmost
		// child in right subtree of parent.
		Node curr = parent.right;
		while (curr.left != null)
			curr = curr.left;

		return curr;
	}

	static Node postorderPredecessor(Node root, Node n) {

		// If right child exists, then it is
		// postorder predecessor.
		if (n.right != null)
			return n.right;

		// If right child does not exist, then
		// travel up (using parent pointers)
		// until we reach a node which is right
		// child of its parent.
		Node curr = n, parent = curr.parent;
		while (parent != null && parent.left == curr) {
			curr = curr.parent;
			parent = parent.parent;
		}

		// If we reached root, then the given
		// node has no postorder predecessor
		if (parent == null)
			return null;

		return parent.left;
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

		Node res = postorderSuccessor(root, root.left.right.right);
		if (res != null)
			System.out.println("Postorder successor of " + root.left.right.right.value + " is " + res.value);
		else
			System.out.println("Postorder successor of " + root.left.right.right.value + " is NULL");

		Node res1 = postorderPredecessor(root, root.left.right);

		if (res != null) {
			System.out.printf("Postorder predecessor " + "of %d is %d\n", root.left.right.value, res1.value);
		} else {
			System.out.printf("Postorder predecessor " + "of %d is null\n", root.left.right.value);
		}
	}
}
