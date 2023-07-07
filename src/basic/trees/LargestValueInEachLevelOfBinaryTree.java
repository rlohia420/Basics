package basic.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValueInEachLevelOfBinaryTree {
	//use the level order traversal via dfs

	 public List<Integer> largestValues(TreeNode root) {
	        List <Integer> list =new LinkedList<>();
	        if(root==null) return list;
	        Queue <TreeNode> q= new LinkedList<>();
	        q.add(root);
	        while(!q.isEmpty()){
	            int size=q.size();
	            int max=Integer.MIN_VALUE;
	            for (int i = 0; i < size; i++) {
	                TreeNode node= q.poll();
	                if(node.left!=null) q.add(node.left);
	                if(node.right!=null) q.add(node.right);
	                max= Math.max(max, node.data);
	            }
	            list.add(max);
	        }
	        return list;
	    }
}
