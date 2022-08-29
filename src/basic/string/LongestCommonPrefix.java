package basic.string;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefix {
	public static String longestCommonPrefix(String[] arr, int n) {
		String result="";
		Map<Character, Integer> map = new HashMap<>();
		int min = Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			min = Math.min(min, arr[i].length());
		}
		for(int j=0;j<min;j++) {
			for(int i=0;i<n;i++) {
				char[] a = arr[i].toCharArray();
				if(map.containsKey(a[j])){
					map.put(a[j], map.get(a[j])+1);
				}else {
					map.put(a[j], 1);
				}
				if(i==n-1 && map.get(a[j])==n) {
					result+=a[j];
				}
			}map.clear();
		}
		System.out.println(arr[0].indexOf(result));
		return arr[0].indexOf(result)==0?result:"";
	}

	public static void main(String args[]) {
		String[] arr = {"kimrekacsf", "kimrettrwa", "kimreeybfg", "timrewwmnr", "kimretjxjl" ,"kimrejecjw"};
		System.out.println(longestCommonPrefix(arr,arr.length));
	}
}
