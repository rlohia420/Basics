package basic.trees;

import basic.trees.BinaryTree.Node;

public class KthLargest {
	static int c=0;
	static void kthLargestUtil(Node node, int k)
    {
        // Base cases, the second condition is important to
        // avoid unnecessary recursive calls
        if (node == null || c >= k)
            return;
          
        // Follow reverse inorder traversal so that the
        // largest element is visited first
        kthLargestUtil(node.right, k); 
          
        // Increment count of visited nodes
        c++;
          
        // If c becomes k now, then this is the k'th largest 
        if (c == k) {
            System.out.println(k + "th largest element is " + 
                                                 node.data);
            return;
        }
          
        // Recur for left subtree
        kthLargestUtil(node.left, k); 
    }
  
    public static void main(String args[]) {
    	//KthLargest kthLargest = new KthLargest();
		 Node n = new Node(30);
	     n.left = new Node(20);
	     n.right = new Node(40);
	     n.left.left = new Node(10);
	     n.left.right = new Node(25);
	     n.right.left = new Node(35);
	     n.right.right = new Node(45);
	     kthLargestUtil(n,3);
	}
	
}
