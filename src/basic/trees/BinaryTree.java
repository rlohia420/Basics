package basic.trees;

public class BinaryTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int item){
            data = item;
            left = right = null;
        }
    }

   /* testing for example nodes */
    public static void main(String args[])
    {
    	Node root = new Node(1);
    	/* preorder traversal
		        12
		       / \
		     10  30   -> 12,10,25,30,40
		        / \
		       25  40
    	 */
    	
        root = new Node(12);
        root.left = new Node(10);
        root.right = new Node(30);
        root.right.left = new Node(25);
        root.right.right = new Node(40);
        System.out.println(TreeOperations.contains(root, 11));
    	Traversals.spiralOrder(root);

        TreeOperations.isBST(root);
        /* creating a binary tree and entering the nodes
                 12
                / \
              10  30   -> 12,10,25
                 / \
                25  40
         */
        root = new Node(12);
        root.left = new Node(10);
        root.right = new Node(30);
        root.right.left = new Node(25);
        root.right.right = new Node(40);

        //LeftViewOfTree.leftViewUtil(root, 1);
        
        /* creating a binary tree and entering the nodes
		        12
		       / \
		     10  30   -> 12,30,40
		        / \
		       25  40
         */
		root = new Node(12);
		root.left = new Node(10);
		root.right = new Node(30);
		root.right.left = new Node(25);
		root.right.right = new Node(40);
		//RightViewOfTree.rightViewUtil(root, 1);

        
        /*top view*/
        TopView topView = new TopView();
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);
       // preOrder(root);
    }

}
