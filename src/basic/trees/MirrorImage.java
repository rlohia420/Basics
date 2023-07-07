package basic.trees;

import basic.trees.BinaryTree.Node;

public class MirrorImage {

	public static Node mirror(BinaryTree.Node node) {
		if(node==null) return null;
		Node left = mirror(node.left);
		Node right = mirror(node.right);
		node.left = right;
		node.right = left;
		return node;
	}
	
	public static boolean isMirror(BinaryTree.Node nodeA,BinaryTree.Node nodeB) {
		if(nodeA==null && nodeB==null) {
			return true;
		}
		if(nodeA!=null || nodeB!=null) {
			return false;
		}
		return (nodeA!=null && nodeB!=null) && (nodeA.data==nodeB.data) 
				&& isMirror(nodeA.left , nodeB.right) 
				&& isMirror(nodeA.right, nodeB.left);
	}
	
	public static boolean isSymetric(BinaryTree.Node node ) {
		return isMirror(node, node);
	}
}
