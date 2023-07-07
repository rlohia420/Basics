package basic.trees;

public class CheckforChildrenSumPropertyInABinaryTree {
/*
 * Given a binary tree, the task is to check for every node, 
 * its value is equal to the sum of values of its immediate left and right child. 
 * For NULL values, consider the value to be 0.
 */
	
	public boolean isSumProperty(Node node)
    {
 
        if (node == null
            || (node.left == null && node.right == null))
            return true;
        else {
            if (node.left != null && node.right != null && (node.data == node.left.data + node.right.data)
                && isSumProperty(node.left) && isSumProperty(node.right) )
                return true;
            else
                return false;
        }
    }
}
