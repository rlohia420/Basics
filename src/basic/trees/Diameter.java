package basic.trees;

/*
 * Diameter is the longest path between two nodes in tree
 * approach:
 * base case if tree is empty
 * get the height of left and right sub-trees
 * get the diameter of left and right sub-trees
 *  Return max of following three
      1) Diameter of left subtree
      2) Diameter of right subtree
      3) Height of left subtree + height of right subtree + 1
     
 * 
 */
public class Diameter {
	
	static Node root;
	static int diameter(Node root)
    {   
        if (root == null)
            return 0; 
        int lheight = height(root.left);
        int rheight = height(root.right);
        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);
 
        return 1 + Math.max(lheight + rheight,
                        Math.max(ldiameter, rdiameter));
    }
	static int height(Node node)
    {
        if (node == null)
            return 0;
        return (1+ Math.max(height(node.left),height(node.right)));
    }
	static int diameter() { return diameter(root); }
	
	public static void main(String args[]) {
		Diameter tree = new Diameter();
	        tree.root = new Node(1);
	        tree.root.left = new Node(2);
	        tree.root.right = new Node(3);
	        tree.root.right.left = new Node(6);
	        tree.root.right.right = new Node(7);
	        tree.root.left.left = new Node(4);
	        tree.root.left.right = new Node(5);
	 
	        // Function Call
	        System.out.println(
	            "The diameter of given binary tree is : "
	            + tree.diameter());
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