package basic.string;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ArrangementOfStringAsc {

	public static void main(String args[]) {
		String[] str = {"HEN","DOG","CAT","CAT","HEN","CAT","RAT","DOG"};
		//o/p - {"RAT","DOG","DOG","HEN,"HEN","CAT,"CAT","CAT"}
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
		list.sort(Comparator.comparing(Entry<String,Integer>::getValue).
				thenComparing(Entry<String,Integer>::getKey));
		
		for(int i=0;i<list.size();i++) {
			for(int j = list.get(i).getValue();j>0;j--)
			System.out.println(list.get(i).getKey() );
		}
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getKey() + " - "+list.get(i).getValue());
		}
	}

}
