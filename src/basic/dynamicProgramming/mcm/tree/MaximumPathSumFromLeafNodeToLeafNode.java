package basic.dynamicProgramming.mcm.tree;

public class MaximumPathSumFromLeafNodeToLeafNode {
	
	//TODO: recheck the logic 
	
	public static Node root;
	public int maxPathSumUtil(Node node, int res) {
		 if(node==null)
			 return 0;
		 int left = maxPathSumUtil(node.left, res);
		 int right = maxPathSumUtil(node.right, res);
		 int temp = Math.max(left,right)+root.data;
		 if(root.left==null && root.right==null) {
			 temp = Math.max(temp,root.data);
		 }
		 int ans = Math.max(temp,left+right+root.data);
		 res = Math.max(res, ans);
		 return ans;
	 }
	public static void main(String args[]) {
		MaximumPathSumFromLeafNodeToLeafNode tree = new MaximumPathSumFromLeafNodeToLeafNode();
        tree.root = new Node(-15);
        tree.root.left = new Node(5);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(-8);
        tree.root.left.right = new Node(1);
        tree.root.left.left.left = new Node(2);
        tree.root.left.left.right = new Node(6);
        tree.root.right.left = new Node(3);
        tree.root.right.right = new Node(9);
        tree.root.right.right.right = new Node(0);
        tree.root.right.right.right.left = new Node(4);
        tree.root.right.right.right.right = new Node(-1);
        tree.root.right.right.right.right.left = new Node(10);
        System.out.println("Max pathSum of the given binary tree is "
                + tree.maxPathSumUtil(root,Integer.MIN_VALUE));
    }
}
