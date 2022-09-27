package leetcode.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PopulatingNextRightPointersInEachNodeII_117 {
	public static List<Node> ll = new ArrayList<>();
	public Node connect(Node root) {
		int level =1;
		while(levelOrder(root, level)) {
			ll.add(null);
			level++;
		}
		return ll.get(0);
	}

	private boolean levelOrder(Node root , int level) {
		if(root==null) {
			return false;
		}
		if(level==1) {
			ll.add(root);
			return true;
		}
		boolean left = levelOrder(root.left, level-1);
		boolean right = levelOrder(root.right, level-1);
		return left||right;
	}
	public static void main(String args[]) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,null,7);
		Node n1 = new Node(list.get(6),null,null,null);
		Node n2 = new Node(list.get(4),null,null,null);
		Node n3 = new Node(list.get(3),null,null,null);
		Node n4 = new Node(list.get(2),null,n1,null);
		Node n5 = new Node(list.get(1),n3,n2,null);
		Node n6 = new Node(list.get(0),n5,n4,null);
		PopulatingNextRightPointersInEachNodeII_117 p = new PopulatingNextRightPointersInEachNodeII_117();
		p.connect(n6);
		for(Node n : ll) {
			System.out.print(n!=null ? n.val :"#");
		}
	}
}

class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
	
};