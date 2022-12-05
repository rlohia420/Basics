package leetcode.trees;

public class SearchInABinarySearchTree_700 {
	public static void main(String args[]) {
		TreeNode n1 = new TreeNode(1,null,null);
		TreeNode n2 = new TreeNode(3,null,null);
		TreeNode n3 = new TreeNode(2,n1,n2);
		TreeNode n5 = new TreeNode(7,null,null);
		TreeNode root = new TreeNode(4,n3,n5);
		searchBST(root,2);
	}
	public static TreeNode searchBST(TreeNode root, int val) {
        if(root.val==val){
            return root;
        }
        if(root.left!=null){
            return searchBST(root.left,val);
        }
        if(root.right!=null){
            return searchBST(root.right,val);
        }
        return null;
    }
	
}


