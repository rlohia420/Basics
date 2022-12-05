package leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_49 {
	public static List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) 
            	map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
	}
	public static void main(String args[]) {
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		List<List<String>>  lst = groupAnagrams(strs);
		for(List<String> list : lst) {
			System.out.println(Arrays.toString(list.toArray()));
		}
	}
}
