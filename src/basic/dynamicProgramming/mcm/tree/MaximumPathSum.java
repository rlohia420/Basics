package basic.dynamicProgramming.mcm.tree;


//https://www.youtube.com/watch?v=Osz-Vwer6rw&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=48
//https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/2581403/Java-or-Very-Easy-or-faster-than-99.7
public class MaximumPathSum {
	
	//TODO: recheck the logic
	public static Node root;
	public int maxPathSum(Node root) {
        int res[]=new int[1];
        res[0]=Integer.MIN_VALUE;
        helper(root,res);
        return res[0];
    }
    
    int helper(Node root,int res[])
    {
        if(root==null)
            return 0;
        
        int left=helper(root.left,res);
        int right=helper(root.right,res);
        
        int tmp=Math.max(root.data,root.data+Math.max(left,right));
        int max=Math.max(tmp,root.data+left+right);
        res[0]=Math.max(max,res[0]);
        return tmp;
    }
    public static void main(String args[]) {
    	MaximumPathSum tree = new MaximumPathSum();
	        tree.root = new Node(1);
	        tree.root.left = new Node(2);
	        tree.root.right = new Node(3);
	        tree.root.right.left = new Node(6);
	        tree.root.right.right = new Node(7);
	        tree.root.left.left = new Node(4);
	        tree.root.left.right = new Node(5);
	 
	        // Function Call
	        System.out.println(
	            "The maximum path in given binary tree is : "
	            + tree.maxPathSum(root));
	       
	}
}
class Node {
    int data;
    Node left, right;

    public Node(int item){
        data = item;
        left = right = null;
    }
    public Node(int item , Node left , Node right) {
    	data = item;
    	this.left = left;
    	this.right = right;
    }
}