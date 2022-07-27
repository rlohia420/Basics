package leetcode.string.medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

public class SumOfBeautyOfAllSubstrings_1781 {
	static HashSet<String> paths = new HashSet<>();
	private static HashSet<String> getSubStrings(String s){
		for(int i=0;i<s.length();i++) {
			for(int j=s.length();j>i;j--) {
				//System.out.println(" "+s.substring(i,j));
				paths.add(s.substring(i,j));
			}
		}
		return paths;
	}

	public static int beautySum(String s) {
		HashSet<String> subStrings = getSubStrings(s);
		int countOfBeautiString = 0;
		Iterator itr  = subStrings.iterator();
		while(itr.hasNext()) {
			countOfBeautiString +=beauti(itr.next().toString());
		}
		return countOfBeautiString;
	}
	private static int beauti(String s) {
		HashMap<Character,Integer> map = new HashMap<>();
		char[] charA = s.toCharArray();
		for(int i=0;i<charA.length;i++) {
			if(map.containsKey(charA[i])) {
				map.put(charA[i], map.get(charA[i])+1);
			}else {
				map.put(charA[i], 1);
			}
		}
		Optional<Integer> non1 = map.values().stream().filter(x->x!=1).findAny();
		 if(!non1.isPresent()) {
			 return 0;
		 }
		int max = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getValue();
		int min = Collections.min(map.entrySet(), Map.Entry.comparingByValue()).getValue();
		return max- min;
	}
	public static void main(String args[]) {
		String s = "otxixllvlxbdlcgwlfrmeiwmhuohckezaljlwnkbnnymqkscliqulevznzasiwadrvabiavjelaqqkabtmyoafzurywotzeovxknkxsuyfpckotvzlrpmmxermkuxwetsjtacklphlucfitdvfkwxzjfiwhkjpxfmkfwphmymmuqvyjgcrjmxlmduoxwjxdmuhchrrlpnwwkeedafodqtrgcmptfgtqnylvxntapwiledizdyllctbgtrmlawagobggmscettdpbiwveopoawghnixgntiuzfwtmpj";
		System.out.println(beautySum(s));
	}
}
