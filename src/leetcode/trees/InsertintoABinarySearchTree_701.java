package leetcode.trees;

public class InsertintoABinarySearchTree_701 {
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) {
			TreeNode node = new TreeNode(val);
			return node;
		}
		if (root != null && root.val < val) {
			root.right = insertIntoBST(root.right, val);
		}
		if (root != null && root.val > val) {
			root.left = insertIntoBST(root.left, val);
		}
		return root;
	}
}
