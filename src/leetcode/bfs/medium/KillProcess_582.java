package leetcode.bfs.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class KillProcess_582 {
	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		if (kill == 0)
			return pid;

		int n = pid.size();
		Map<Integer, Set<Integer>> tree = new HashMap<>();
		for (int i = 0; i < n; i++) {
			tree.put(pid.get(i), new HashSet<Integer>());
		}
		for (int i = 0; i < n; i++) {
			if (tree.containsKey(ppid.get(i))) {
				Set<Integer> children = tree.get(ppid.get(i));
				children.add(pid.get(i));
				tree.put(ppid.get(i), children);
			}
		}

		List<Integer> result = new ArrayList<>();
		traverse(tree, result, kill);

		return result;
	}

	private void traverse(Map<Integer, Set<Integer>> tree, List<Integer> result, int pid) {
		result.add(pid);

		Set<Integer> children = tree.get(pid);
		for (Integer child : children) {
			traverse(tree, result, child);
		}
	}
	public static void main(String args[]) {
		List<Integer> pid = Arrays.asList(1,3,10,5);
		List<Integer> ppid =Arrays.asList(3,0,5,3); 
		int kill = 5;
		KillProcess_582 k = new KillProcess_582();
		List<Integer> res = k.killProcess(pid,ppid,kill);
		for(Integer i:res)
		System.out.println(i);

	}
}
