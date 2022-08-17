package sliding.window.problems;

import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=Lav6St0W_pQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=10
public class LongestSubStringWithKUniqueCharacter_VW_3 {

	public static void main(String args[]) {
		String str = "aabacbebebe";
		int k=3;
		System.out.println(longest(str,k));
	}
	public static int longest(String str , int k) {
		int i=0,j=0;
		int max = Integer.MIN_VALUE;
		int size = str.length();
		Map<Character,Integer> map = new HashMap<>();
		while(j<size) {
			if(map.containsKey(str.charAt(j))) {
				map.put(str.charAt(j), map.get(str.charAt(j))+1);
			}else {
				map.put(str.charAt(j), 1);
			}
			if(map.size() < k) {
				j++;
			}else if(map.size()==k) {
				max = Math.max(max, j-i+1);
				j++;
			}else if(map.size() > k) {
				while(map.size() > k) {
					map.put(str.charAt(i),map.get(str.charAt(i))-1);
					if(map.get(str.charAt(i))==0) {
						map.remove(str.charAt(i));
					}
					i++;
				}
				j++;
			}
		}
		return max;
	}
	
	public static int totalFruit(int[] fruits) {
		int i=0,j=0;
		int max = Integer.MIN_VALUE;
		int size = fruits.length;
		int k=2;
		Map<Integer,Integer> map = new HashMap<>();
		while(j<size) {
			if(map.containsKey(fruits[j])) {
				map.put(fruits[j], map.get(fruits[j])+1);
			}else {
				map.put(fruits[j], 1);
			}
			if(map.size() < k) {
				j++;
			}else if(map.size()==k) {
				max = Math.max(max, j-i+1);
				j++;
			}else if(map.size() > k) {
				while(map.size() > k) {
					map.put(fruits[i],map.get(fruits[i])-1);
					if(map.get(fruits[i])==0) {
						map.remove(fruits[i]);
					}
					i++;
				}
				j++;
			}
		}
		return max;
	}
}
