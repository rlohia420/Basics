package basic.trees;

import basic.trees.BinaryTree.Node;

public class CheckIfAGivenBinaryTreeIsSumTree {

	public static void main(String args[]) {
		   /*
         *   26
        /   \
      10     3
    /    \     \
  4      6      3
         */
        Node n = new Node(28);
        n.left = new Node(11);
        n.left.left = new Node(3);
        n.left.right = new Node(8);
        n.right = new Node(3);
        n.right.right = new Node(3);
        System.out.println(CheckIfAGivenBinaryTreeIsSumTree.sumTree(n,n.left,n.right));
	}
	public static boolean sumTree(BinaryTree.Node n , BinaryTree.Node left, BinaryTree.Node right) {
		if(n==null) {
			return false;
		}
		if(n!=null && n.data == (left!=null?left.data:0) + (right!=null?right.data:0)) {
			return true;
		}
		boolean lSum = sumTree(left,left!=null?left.left:null,left!=null?left.right:null);
		boolean rSum = sumTree(right,right!=null?right.left:null,right!=null?right.right:null);
		return (lSum && rSum);
				
	}
}
