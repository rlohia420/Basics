package basic.trees;

import basic.trees.BinaryTree.Node;

public class Height {

	public int height(Node node) {
		if(node==null) {
			return 0;
		}
		return 1+ Math.max(height(node.left), height(node.right));
	}
	
	public static void main(String[] args)
    {
		Height h = new Height();    
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println(TreeOperations.contains(root, 11));
    	
        
        
        
        System.out.println("Height of tree is "
                           + h.height(root));
    }
}
