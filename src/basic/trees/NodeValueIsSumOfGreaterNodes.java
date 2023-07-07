package basic.trees;

import basic.trees.BinaryTree.Node;

public class NodeValueIsSumOfGreaterNodes {
/*
 * Given a BST, transform it into greater sum tree where each node contains
 *  sum of all nodes greater than that node.

Example 1:

Input:
           2
         /   \
        1     6
             / \
            3   7
Output: 18 16 13 7 0
Explanation:
Every node is replaced with the 
sum of nodes greater than itself. 
The resultant tree is:
               16
             /    \
           18       7
                  /   \
                 13    0
 */
	private static int sum = 0;
	public static void main(String args[]) {
		 Node n = new Node(2);
	     n.left = new Node(1);
	     n.right = new Node(6);
	     n.right.left = new Node(3);
	     n.right.right = new Node(7);
	     sum(n);
	     transform(n);
	}
	public static void sum(Node root) {
		if(root.left!=null) sum(root.left);
		sum = sum+root.data;
		if(root.right!=null) sum(root.right);
	}
	public static void transform(Node root) {
		if(root.left!=null) transform(root.left);
		sum = sum-root.data;
		System.out.println(sum);
		if(root.right!=null) transform(root.right);
	}
}
