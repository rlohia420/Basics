package basic.trees;

import basic.linkedlist.LinkedList;

public class IsGivenLinkedListExistInBinaryTree {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode() {}
	 *     ListNode(int val) { this.val = val; }
	 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode() {}
	 *     TreeNode(int val) { this.val = val; }
	 *     TreeNode(int val, TreeNode left, TreeNode right) {
	 *         this.val = val;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
	 */
    private boolean check(BinaryTree.Node root, LinkedList.Node node) {
        if (node == null) return true;
        if (root == null) return false;
        if (root.data == node.data) {
            boolean a = check(root.left, node.next);
            boolean b = check(root.right, node.next);
            return a || b;
        }
        
        return false;
    }
    
    public boolean isSubPath(LinkedList.Node head, BinaryTree.Node root) {
        if (head == null) return true;
        if (root == null) return false;
        if (check(root, head)) return true;
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }
}
