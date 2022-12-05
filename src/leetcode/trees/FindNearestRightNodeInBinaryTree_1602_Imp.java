package leetcode.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class FindNearestRightNodeInBinaryTree_1602_Imp {

	/*
	 * Given the root of a binary tree and a node u in the tree, return the nearest
	 * node on the same level that is to the right of u, or return null if u is the
	 * rightmost node in its level. Example 1:
	 * 
	 * Input: root = [1,2,3,null,4,5,6], u = 4 Output: 5 Explanation: The nearest
	 * node on the same level to the right of node 4 is node 5.
	 */
	private static List<Integer> queue = new LinkedList<>();
	public static void main(String args[]) {
		FindNearestRightNodeInBinaryTree_1602_Imp ff = new FindNearestRightNodeInBinaryTree_1602_Imp();
		List<Integer> root = Arrays.asList(1, 2, 3, null, 4, 5, 6);
		int u = 4;
		TreeNode treeNode = ff.convert(null, root);
		ff.levelOrder(treeNode);
		System.out.println(queue.get(queue.indexOf(u)+1));
	}

	public TreeNode convert(TreeNode node, List<Integer> list) {
		int i = 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		node = new TreeNode(list.get(i));
		q.add(node);
		i = i + 1;
		while (list!=null && i < list.size()) {
			TreeNode parent = q.peek();
			TreeNode leftChild = null, rightChild = null;
			leftChild =list.get(i)!=null? new TreeNode( list.get(i)) : null;
			q.add(leftChild);
			i++;
			if (list.get(i) != null) {
				rightChild = list.get(i)!=null? new TreeNode(list.get(i)) : null;
				q.add(rightChild);
				i++;
			}
			parent.left = leftChild;
			parent.right = rightChild;
			q.poll();
		}
		return node;

	}
	
	public void levelOrder(TreeNode tn) {
		int level = 1;
		while (levelOrder(tn, level)) {
			level++;
		}
	}

	private boolean levelOrder(TreeNode tn, int level) {
		if (tn == null) {
			return false;
		}
		if (level == 1) {
			//System.out.println(tn.val);
			queue.add(tn.val);
			return true;
		}
		boolean left = levelOrder(tn.left, level-1);
		boolean right = levelOrder(tn.right, level-1);
		return left || right;
	}
}


