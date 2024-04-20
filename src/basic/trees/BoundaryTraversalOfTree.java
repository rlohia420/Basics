package basic.trees;

import java.util.ArrayList;
import java.util.List;

import basic.trees.BinaryTree.Node;

public class BoundaryTraversalOfTree {
	void printLeaves(Node node)
    {
        if (node == null)
            return;
 
        printLeaves(node.left);
        // Print it if it is a leaf node
        if (node.left == null && node.right == null)
            System.out.print(node.data + " ");
        printLeaves(node.right);
    }
 
    // A function to print all left boundary nodes, except a leaf node.
    // Print the nodes in TOP DOWN manner
    void printBoundaryLeft(Node node)
    {
        if (node == null)
            return;
 
        if (node.left != null) {
            // to ensure top down order, print the node
            // before calling itself for left subtree
            System.out.print(node.data + " ");
            printBoundaryLeft(node.left);
        }
        else if (node.right != null) {
            System.out.print(node.data + " ");
            printBoundaryLeft(node.right);
        }
 
        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }
 
    // A function to print all right boundary nodes, except a leaf node
    // Print the nodes in BOTTOM UP manner
    void printBoundaryRight(Node node)
    {
        if (node == null)
            return;
 
        if (node.right != null) {
            // to ensure bottom up order, first call for right
            // subtree, then print this node
            printBoundaryRight(node.right);
            System.out.print(node.data + " ");
        }
        else if (node.left != null) {
            printBoundaryRight(node.left);
            System.out.print(node.data + " ");
        }
        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }
 
    // A function to do boundary traversal of a given binary tree
    void printBoundary(Node node)
    {
        if (node == null)
            return;
 
        System.out.print(node.data + " ");
 
        // Print the left boundary in top-down manner.
        printBoundaryLeft(node.left);
 
        // Print all leaf nodes
        printLeaves(node.left);
        printLeaves(node.right);
 
        // Print the right boundary in bottom-up manner
        printBoundaryRight(node.right);
    }
 
    // Driver program to test above functions
    public static void main(String args[])
    {
        /*
                        20
                       /  \
                     8     22
                    / \     \
                   4   12    25
                    \  / \     \
                    5 10  14    2

         */
    	 BoundaryTraversalOfTree boundary= new BoundaryTraversalOfTree();
    	 Node n = new Node(20);
	     n.left = new Node(8);
	     n.left.left = new Node(4);


	     //n.left.left.left = new Node(1);
	     n.left.left.right = new Node(5);
	     n.left.right = new Node(12);
	     n.left.right.left = new Node(10);
	     n.left.right.right = new Node(14);
	     n.right = new Node(22);
	     n.right.right = new Node(25);
        n.right.right.right = new Node(2);
	     boundary.boundary(n);
       
    }
    
    //===============ANOTHER APPROACH========
    //https://www.youtube.com/watch?v=s1d8UGDCCN8
    private static void printLeft(Node node , List<Integer> ans) {
    	if(node==null || (node.left==null && node.right==null)) {
    		return;
    	}
    	ans.add(node.data);
    	if(node.left!=null) {
    		printLeft(node.left,ans);
    	}
    	else {
    		printLeft(node.right,ans);
    	}
    }
    private static void printLeaf(Node node , List<Integer> ans) {
    	if(node==null) {
    		return;
    	}
    	if(node.left==null && node.right==null) {
    		ans.add(node.data);
    		return;
    	}
    	printLeaf(node.left,ans);
    	printLeaf(node.right,ans);
    }
    private static void printRight(Node node , List<Integer> ans) {
    	if(node==null || (node.left==null && node.right==null)) {
    		return;
    	}
    	if(node.right!=null) {
    		printRight(node.right,ans);
    	}
    	else {
    		printRight(node.left,ans);
    	}
    	ans.add(node.data);
    }
    private static void boundary(Node node) {
    	List<Integer> ans = new ArrayList<>();
    	if(node==null) {
    		return ;
    	}
    	ans.add(node.data);
    	printLeft(node.left,ans);
    	printLeaf(node.left,ans);
    	printLeaf(node.right,ans);
    	printRight(node.right,ans);
    	for(int i=0;i<ans.size();i++) {
    		System.out.println(ans.get(i));
    	}
    	
    }
    /*public static void main(String args[]) {
        /*
                2
              / \
            1    6
           /    / \
          6    3   7
                    \
                    9

            Node n = new Node(2);
            n.left = new Node(1);
            n.right = new Node(6);
            n.right.left = new Node(3);
            n.right.right = new Node(7);
            n.right.right.right = new Node(9);
            boundary(n);
        }
    }*/
}
