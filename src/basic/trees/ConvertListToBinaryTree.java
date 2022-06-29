package basic.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConvertListToBinaryTree {

	public static void main(String args[]) {
		List<Integer> root = Arrays.asList(1, 2, 3, null, 4, 5, 6);
		TreeNode binaryTreeNode = convert(null,root);
		levelOrder(binaryTreeNode);
	}

	public static TreeNode convert(TreeNode node, List<Integer> list) {
		int i = 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		node = new TreeNode(list.get(i));
		q.add(node);
		//i = i + 1;
		for (i=i + 1;list!=null && i < list.size();) {
			TreeNode parent = q.peek();
			TreeNode leftChild = null, rightChild = null;
			leftChild =list.get(i)!=null? new TreeNode( list.get(i)) : null;
			q.add(leftChild);
			i++;
			if (list.get(i) != null) {
				rightChild = new TreeNode(list.get(i));
				q.add(rightChild);
				i++;
			}
			parent.left = leftChild;
			parent.right = rightChild;
			q.poll();
		}
		return node;

	}


	private static void levelOrder(TreeNode tn) {
		int level = 1;
		while (levelOrder(tn, level)) {
			level++;
		}
	}

	private static boolean levelOrder(TreeNode tn, int level) {
		if (tn == null) {
			return false;
		}
		if (level == 1) {
			System.out.println(tn.data);
			return true;
		}
		boolean left = levelOrder(tn.left, level-1);
		boolean right = levelOrder(tn.right, level-1);
		return left || right;
	}
}

class TreeNode {
	int data;
	TreeNode left, right = null;

	TreeNode(int data) {
		this.data = data;
		left = right = null;
	}
}