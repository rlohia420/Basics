package leetcode.bfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class StepByStepDirectionsFromBinaryTreeNodeToAnother_2096 {
	String ans = "";
    int startVal;
    Map<TreeNode, TreeNode> parents = new HashMap<>();
    TreeNode startNode = null;
    public String getDirections(TreeNode root, int start, int end) {
        startVal = start;
        updateMaps(root, null);
        Queue<Pair<TreeNode, String>> q = new LinkedList<>();
        q.add(new Pair(startNode,""));
        Set<Integer> visited = new HashSet<>();
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0;i<size;i++) {
                Pair p = q.poll();
                TreeNode curNode = (TreeNode)p.getKey();
                String curStr = (String)p.getValue();
                visited.add(curNode.val);
                if (curNode.val == end) {
                    return curStr;
                }
                if (parents.get(curNode) != null && !visited.contains(parents.get(curNode).val)) {
                    q.add(new Pair(parents.get(curNode), curStr+"U"));
                }
                if (curNode.left != null && !visited.contains(curNode.left.val)) {
                    q.add(new Pair(curNode.left, curStr+"L"));
                }
                if (curNode.right != null && !visited.contains(curNode.right.val)) {
                    q.add(new Pair(curNode.right, curStr+"R"));
                }
            }
        }
        return "";
    }
    
    public void updateMaps(TreeNode root, TreeNode par) {
        if (root.val == startVal) {
            startNode = root;
        }
        parents.put(root, par);
        if (root.left != null) {
            updateMaps(root.left, root);
        }
        if (root.right != null) {
            updateMaps(root.right, root);
        }        
    }   
    
    
    public static void main(String args[]) {
    	short neha= 1;
    	neha =(short) (neha+1);
    	System.out.println(neha);
    }
}
