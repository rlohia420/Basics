package basic.trees;

import basic.trees.BinaryTree.Node;

public class Traversals {

	public static void preOrder(BinaryTree.Node node) {
		System.out.print(node.data + " ");
		if (node.left != null) {
			preOrder(node.left);
		}
		if (node.right != null) {
			preOrder(node.right);
		}
	}

	public static void postOrder(BinaryTree.Node node) {
		if (node.left != null) {
			postOrder(node.left);
		}
		if (node.right != null) {
			postOrder(node.right);
		}
		System.out.print(node.data + " ");
	}

	public static void inOrder(BinaryTree.Node node) {
		if (node.left != null) {
			inOrder(node.left);
		}
		System.out.print(node.data + " ");
		if (node.right != null) {
			inOrder(node.right);
		}
	}

	public static void levelOrder(BinaryTree.Node node) {
		if(node==null) return;
		int level =1;
		while(levelOrder(node,level)) { level++;}
	}
	private static boolean levelOrder(BinaryTree.Node node , int level) {
		if(node==null) return false;
		if(level==1) {
			System.out.print(node.data+" ") ;
			return true;
		}
		boolean left = levelOrder(node.left, level-1);
		boolean right = levelOrder(node.right, level-1);
		return left||right;
	}

	public static void spiralOrder(BinaryTree.Node node) {
		if(node == null) return;
		int level =1;
		while(leftToRightOrder(node, level++) && rightToLeftOrder(node,level++));
	}
	
	private static boolean leftToRightOrder(BinaryTree.Node node , int level) {
		if(node==null) return false;
		if(level==1) {
			System.out.print(node.data+" ");
			return true;
		}
		boolean left = leftToRightOrder(node.left,level-1);
		boolean right = leftToRightOrder(node.right,level-1);
		return left||right;
	}
	private static boolean rightToLeftOrder(BinaryTree.Node node , int level) {
		if(node==null) return false;
		if(level==1) {
			System.out.print(node.data+" ");
			return true;
		}
		boolean left = rightToLeftOrder(node.right,level-1);
		boolean right = rightToLeftOrder(node.left,level-1);
		return left||right;
	}
	public static void main(String args[]) {
		 Node n = new Node(2);
	     n.left = new Node(1);
	     n.right = new Node(6);
	     n.right.left = new Node(3);
	     n.right.right = new Node(7);
	     inOrder(n);
	}
}
