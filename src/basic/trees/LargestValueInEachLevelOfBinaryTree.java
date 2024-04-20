package basic.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValueInEachLevelOfBinaryTree {
	//use the level order traversal via dfs

	 public static List<Integer> largestValues(BinaryTree.Node root) {
	        List <Integer> list =new LinkedList<>();
	        if(root==null) return list;
	        Queue <BinaryTree.Node> q= new LinkedList<>();
	        q.add(root);
	        while(!q.isEmpty()){
	            int size=q.size();
	            int max=Integer.MIN_VALUE;
	            for (int i = 0; i < size; i++) {
					BinaryTree.Node node= q.poll();
	                if(node.left!=null) q.add(node.left);
	                if(node.right!=null) q.add(node.right);
	                max= Math.max(max, node.data);
	            }
	            list.add(max);
	        }
	        return list;
	    }
	public static void main(String args[]) {
		   /*
         *   26
        /   \
      10     3
    /    \     \
  4      6      3
         */
		BinaryTree.Node n = new BinaryTree.Node(28);
		n.left = new BinaryTree.Node(11);
		n.left.left = new BinaryTree.Node(3);
		n.left.right = new BinaryTree.Node(8);
		n.right = new BinaryTree.Node(3);
		n.right.right = new BinaryTree.Node(2);
		n.right.left = new BinaryTree.Node(1);
		System.out.println(LargestValueInEachLevelOfBinaryTree.largestValues(n));
	}
}
