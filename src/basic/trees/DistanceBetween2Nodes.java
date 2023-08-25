package basic.trees;

import leetcode.trees.LowestCommonAncestorOfABinaryTree_236;
import leetcode.trees.TreeNode;

public class DistanceBetween2Nodes {
	public int findDistance(TreeNode root, int p, int q) {
        if (p == q)
            return 0;
        TreeNode ancestor = lowestCommonAncestor(root, p, q);
        return getDistance(ancestor, p) + getDistance(ancestor, q) - 2;
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
            return 0;
        if (node.val == val)
            return 1;
        int a = getDistance(node.left, val);
        int b = getDistance(node.right, val);
        if(a==0 && b==0) return 0;
        else return a+b+1;
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
    
    public static void main(String[] args) {
		LowestCommonAncestorOfABinaryTree_236 out = new LowestCommonAncestorOfABinaryTree_236();
		DistanceBetween2Nodes distanceBetween2Nodes = new DistanceBetween2Nodes();
        TreeNode root = new TreeNode(3);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);

        root.left = p;
        root.right = q;

        System.out.println(distanceBetween2Nodes.findDistance(root, 5, 1));


        TreeNode root2 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);

        root2.left = p2;

        System.out.println(out.lowestCommonAncestor(root2, p2, root2).val);

    }

}
