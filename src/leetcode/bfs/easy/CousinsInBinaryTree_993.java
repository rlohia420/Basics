package leetcode.bfs.easy;

public class CousinsInBinaryTree_993 {
	static int lh=0 ;
	static int rh =0;
	static boolean ans = true;
	public static void cusion(TreeNode root, int x, int y,int level){
	    if(root == null){
	        return;
	    } 
	    if(root.left != null && root.right != null){
	        if(root.left.val == x && root.right.val == y || root.right.val ==x && root.left.val ==y){
	            ans = false;
	            return;
	        }
	    }
	    if(root.val == x){
	        lh = level;
	    }
	    if(root.val == y){
	        rh = level;
	    }
	    cusion(root.left,x,y,level+1);
	    cusion(root.right,x,y,level+1);   
	}

	public static boolean isCousins(TreeNode root, int x, int y) {
	    
	    cusion(root,x,y,0);
	    System.out.println(lh);
	    System.out.println(rh);
	    if(lh != rh){
	        ans = false;
	    }
	    return ans;
	}

	public static void main(String args[]) {
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(2,node1,null);
		TreeNode node3 = new TreeNode(3);
		TreeNode node5 = new TreeNode(1,node2,node3);
		System.out.println(isCousins(node5,4,3));
	}
}

