package basic.trees;

public class CheckforChildrenSumPropertyInABinaryTree {
/*
 * Given a binary tree, the task is to check for every node, 
 * its value is equal to the sum of values of its immediate left and right child. 
 * For NULL values, consider the value to be 0.
 */
    public static boolean sumTree(BinaryTree.Node n ) {
        if(n==null) {
            return false;
        }
        if(n!=null && n.data == (n.left!=null?n.left.data:0) + (n.right!=null?n.right.data:0)) {
            return true;
        }
        boolean lSum = sumTree(n.left);
        boolean rSum = sumTree(n.right);
        return (lSum && rSum);

    }
    public static void main(String args[]) {
		   /*
         *   26
        /   \
      10     3
    /    \     \
  4      6      3
         */
        BinaryTree.Node n = new BinaryTree.Node(28);
        n.left = new BinaryTree.Node(11);
        n.left.left = new BinaryTree.Node(3);
        n.left.right = new BinaryTree.Node(8);
        n.right = new BinaryTree.Node(3);
        n.right.right = new BinaryTree.Node(2);
        n.right.left = new BinaryTree.Node(1);
        System.out.println(CheckforChildrenSumPropertyInABinaryTree.sumTree(n));
    }
}
