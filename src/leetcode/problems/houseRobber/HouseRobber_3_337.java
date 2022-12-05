package leetcode.problems.houseRobber;

import java.util.HashMap;

import leetcode.trees.TreeNode;

public class HouseRobber_3_337 {
	 public int rob(TreeNode root) {
	        if (root.left == null && root.right == null) {
	            return root.val;
	        }
	        return robHelp(root, new HashMap<>());
	    }
	    
	    public int robHelp(TreeNode root, HashMap<TreeNode, Integer> hm) {
	        if (root == null) {
	            return 0;
	        }
	        if (hm.containsKey(root)) {
	            return hm.get(root);
	        }
	        int ans = 0;
	        if (root.left != null) {
	            ans += robHelp(root.left.left, hm) + robHelp(root.left.right, hm);
	        }
	        if (root.right != null) {
	            ans += robHelp(root.right.left, hm) + robHelp(root.right.right, hm);
	        }
	        ans += root.val;
	        ans = Math.max(ans, robHelp(root.left, hm) + robHelp(root.right, hm));
	        hm.put(root, ans);
	        return ans;
	    }
}
