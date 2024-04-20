package leetcode.trees;

public class SumOfLeftAndRightLeaves_404 {

    public static int sumLeft =0;
    public static int sumRight =0;

    public static int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0 ;

        if(root.left!=null) sumOfLeftLeaves(root.left);
        if(root.right!=null) sumOfLeftLeaves(root.right);
        if(root.left!=null && root.left.left==null && root.left.right==null)
	    	return sumLeft+=root.left.val;
	    else
	    	return sumLeft;
    }

    public static int sumOfRightLeaves(TreeNode root) {
        if(root==null) return 0 ;

        if(root.right!=null) sumOfRightLeaves(root.right);
        if(root.left!=null) sumOfRightLeaves(root.left);

        if(root.right!=null && root.right.right==null && root.right.left==null)
            return sumRight+=root.right.val;
        else
            return sumRight;
    }

    public static void main(String args[]) {
        /*
                3
              / \
            9   20
           /    / \
          6    15  7
         */
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(15);
        TreeNode node6 = new TreeNode(6 );
        TreeNode node3 = new TreeNode(9 , node6,null);
        TreeNode node4 = new TreeNode(20,node2,node1);
        TreeNode node5 = new TreeNode(3,node3,node4);
        System.out.println(sumOfLeftLeaves(node5));

        System.out.println(sumOfRightLeaves(node5));

        System.out.println("Sum Of all leaves = "+ (sumLeft+ sumRight));
    }
}
