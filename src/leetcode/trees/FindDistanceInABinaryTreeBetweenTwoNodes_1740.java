package leetcode.trees;

public class FindDistanceInABinaryTreeBetweenTwoNodes_1740 {
	public int findDistance(TreeNode root, int p, int q) {
        if (p == q)
            return 0;
        TreeNode ancestor = lowestCommonAncestor(root, p, q);
        return getDistance(ancestor, p) + getDistance(ancestor, q);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root == null)
            return null;
        if (root.val == p || root.val == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)
            return root;
        return left == null ? right : left;
    }

    public int getDistance(TreeNode node, int val) {
        if (node == null)
            return -1;
        if (node.val == val)
            return 0;
        int leftDistance = getDistance(node.left, val);
        int rightDistance = getDistance(node.right, val);
        int subDistance = Math.max(leftDistance, rightDistance);
        return subDistance >= 0 ? subDistance + 1 : -1;
    }
    
    public static int findLevel(TreeNode root, int a, int level)
    {
        if (root == null)
            return -1;
        if (root.val == a)
            return level;
        int left = findLevel(root.left, a, level + 1);
        if (left == -1)
            return findLevel(root.right, a, level + 1);
        return left;
    }
 
    public int findDistanceNew(TreeNode root, int a, int b)
    {
        TreeNode lca = lowestCommonAncestor(root, a, b);
 
        int d1 = findLevel(lca, a, 0);
        int d2 = findLevel(lca, b, 0);
 
        return d1 + d2;
    }
}
