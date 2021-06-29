package basic.trees;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LeftViewOfTree {
    static Map<Integer,Integer> map = new HashMap<>();
    // recursive function to print left view
    public static void leftViewUtil(BinaryTree.Node node, int level)
    {
        System.out.println("Following are nodes in"+ " left view of Binary Tree");
    	leftView(node,level,map);
    	for(Entry<Integer,Integer> entry: map.entrySet()) {
    		System.out.println(entry.getValue());
    	}
    }
    private static void leftView(BinaryTree.Node node,int level,Map<Integer,Integer> map) {
    	if(node==null)
    		return;
    	if(!map.containsKey(level)) {
    		map.put(level, node.data);
    	}
    	leftView(node.left,level+1,map);
    	leftView(node.right,level+1,map);
    }
}
