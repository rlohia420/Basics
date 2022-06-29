package leetcode.trees.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneNArrayTree_1490_Imp {
	private Map<NNode, NNode> map = new HashMap<>();
	public NNode cloneTree(NNode root) {
	    if (root == null)
	      return null;
	    if (map.containsKey(root))
	      return map.get(root);

	    NNode newNode = new NNode(root.val);
	    map.put(root, newNode);

	    for (NNode child : root.children)
	      newNode.children.add(cloneTree(child));

	    return newNode;
	  }


}

class NNode {
    int val;
    List<NNode> children;
 
    NNode() {}
 
    NNode(int _val) {
        val = _val;
    }
 
    NNode(int _val, List<NNode> _children) {
        val = _val;
        children = _children;
    }
}
