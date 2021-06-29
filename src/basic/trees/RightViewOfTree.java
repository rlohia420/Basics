package basic.trees;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RightViewOfTree {
	private static Map<Integer, Integer> map = new HashMap<>();

	public static void rightViewUtil(BinaryTree.Node node, int level) {
		System.out.println("Following are nodes in" + " right view of Binary Tree");
		rightView(node, level,map);
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getValue());
		}
	}

	private static void rightView(BinaryTree.Node node, int level,Map<Integer, Integer> map) {
		if (node == null)
			return;
		if (!map.containsKey(level)) {
			map.put(level, node.data);
		}
		rightView(node.right, level + 1 , map);
		rightView(node.left, level + 1 , map);
	}

}
