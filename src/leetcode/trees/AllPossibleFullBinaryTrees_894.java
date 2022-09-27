package leetcode.trees;

import java.util.ArrayList;
import java.util.List;


public class AllPossibleFullBinaryTrees_894 {
	public static List<TreeNode> allPossibleFBT(int n) {
		List<TreeNode> result = new ArrayList<>();
		if (n <= 0 || n % 2 == 0) {
			return result;
		}

		if (n == 1) {
			result.add(new TreeNode(0));
		}

		for (int i = 1; i < n; i += 2) {
			List<TreeNode> leftchildren = allPossibleFBT(i);
			List<TreeNode> rightchildren = allPossibleFBT(n - i - 1);

			for (TreeNode left : leftchildren) {
				for (TreeNode right : rightchildren) {
					result.add(new TreeNode(0, left, right));
				}
			}
		}
		return result;
	}
	public static void main(String args[]) {
		List<TreeNode> list = allPossibleFBT(2);
		System.out.println(list.size() + " size ");
		for(TreeNode tree: list) {
			System.out.println(tree.val);
		}
	}
}
 class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}