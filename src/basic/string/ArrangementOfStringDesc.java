package basic.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ArrangementOfStringDesc {

	public static void main(String args[]) {
		String[] str = {"HEN","DOG","CAT","CAT","HEN","CAT","RAT","DOG"};
		//o/p - {"CAT,"CAT","CAT","DOG","DOG","HEN,"HEN",RAT}
		arrangement(str);
	}
	private static void arrangement(String[] str) {
		Map<String,Integer> map = new LinkedHashMap<>();
		for(int i=0;i<str.length;i++) {
			if(map.containsKey(str[i])) {
				map.put(str[i], map.get(str[i])+1);
			}else {
				map.put(str[i], 1);
			}
		}
		Set<Entry<String,Integer>> set = map.entrySet();
		List<Entry<String,Integer>> list = new ArrayList<>(set);
		Collections.sort(list,new Comparator<Entry<String,Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				int val = o2.getValue().compareTo(o1.getValue());
				if(val==0) {
					return o1.getKey().compareTo(o2.getKey());
				}else {
					return o2.getValue().compareTo(o1.getValue());
				}
			}
		
		});
		List<String> s = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getKey() + " - "+list.get(i).getValue());
			for(int j=list.get(i).getValue();j>0;j--)
				s.add(list.get(i).getKey());
		}
		for(int i=0;i<s.size();i++) {
			System.out.println(s.get(i)+" ");
		}
		
	}
}
