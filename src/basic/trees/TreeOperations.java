package basic.trees;

import basic.trees.BinaryTree.Node;

public class TreeOperations {

	public static void insert(BinaryTree.Node node, int data) {
		if (node.data > data) {
			if (node.left == null) {
				node.left = new Node(data);
			} else {
				insert(node.left, data);
			}
		} else {
			if (node.right == null) {
				node.right = new Node(data);
			} else {
				insert(node.right, data);
			}
		}
	}

	public static boolean contains(BinaryTree.Node node, int data) {
		if (node == null)
			return false;
		if (node.data == data) {
			return true;
		} else if (node.data > data) {
			return contains(node.left, data);
		} else {
			return contains(node.right, data);
		}
	}

	public static boolean isIdentical(BinaryTree.Node nodeA, BinaryTree.Node nodeB) {
		if (nodeA == null && nodeB == null)
			return true;
		else {
			return (nodeA != null && nodeB != null) && (nodeA.data == nodeB.data) && isIdentical(nodeA.left, nodeB.left)
					&& isIdentical(nodeA.right, nodeB.right);
		}
	}

	public static int height(BinaryTree.Node node) {
		if (node == null)
			return 0;
		return 1 + Math.max(height(node.left), height(node.right));
	}

	public static Node deleteNode(BinaryTree.Node node, int key) {
		if (node == null)
			return null;
		if (key < node.data) {
			node.left = deleteNode(node.left, key);
		} else if (key > node.data) {
			node.right = deleteNode(node.right, key);
		} else if (node.left == null && node.right == null) {
			return null;
		} else if (node.left != null && node.right != null) {
			Node predecessor = maximumKey(node.left);
			node.data = predecessor.data;
			node.left = deleteNode(node.left, predecessor.data);
		} else {
			Node child = node.left != null ? node.left : node.right;
			node = child;
			return node;
		}
		return node;
	}

	private static Node maximumKey(BinaryTree.Node ptr) {
		while (ptr.right != null) {
			ptr = ptr.right;
			return ptr;
		}
		return ptr;
	}

	public static boolean isBST(Node node, int minKey, int maxKey) {
		// base case
		if (node == null) {
			return true;
		}
		// if the node's value falls outside the valid range
		if (node.data < minKey || node.data > maxKey) {
			return false;
		}
		// recursively check left and right subtrees with an updated range
		return isBST(node.left, minKey, node.data) && isBST(node.right, node.data, maxKey);
	}

	// Function to determine whether a given binary tree is a BST
	public static void isBST(Node root) {
		if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
			System.out.println("The tree is a BST.");
		} else {
			System.out.println("The tree is not a BST!");
		}
	}
}
