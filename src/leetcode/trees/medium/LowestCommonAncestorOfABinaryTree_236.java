package leetcode.trees.medium;

public class LowestCommonAncestorOfABinaryTree_236 {

	public static void main(String[] args) {
		LowestCommonAncestorOfABinaryTree_236 out = new LowestCommonAncestorOfABinaryTree_236();

        TreeNode root = new TreeNode(3);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);

        root.left = p;
        root.right = q;

        System.out.println(out.lowestCommonAncestor(root, p, q).val);


        TreeNode root2 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);

        root2.left = p2;

        System.out.println(out.lowestCommonAncestor(root2, p2, root2).val);

    }

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null) {
			return null;
		}

		if (root == p || root == q) { // key is here, especially when p is parent of q or vice-versa
			return root;
		}

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left != null && right != null) {
			return root;
		} else if (left == null && right == null) {
			return null;
		} else if (left == null && right != null) {
			return right;
		} else { // left != null && right == null
			return left;
		}
	}
}
