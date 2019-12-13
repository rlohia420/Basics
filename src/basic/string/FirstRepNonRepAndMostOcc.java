package basic.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FirstRepNonRepAndMostOcc {

	// Find the first repeatative , non-repeattative and most occured character in
	// String
	public static void main(String args[]) {

		getCharacters("NehaLohia");
	}

	public static void getCharacters(String str) {
		boolean repeat = true , nonRepeat=true; int large=0;
		char repeatChar=0; char nonRepeatChar=0,mostOccuredChar=0;
		Map<Character, Integer> map = new HashMap<>();
		for (char key : str.toCharArray()) {
			if (map.containsKey(key)) {
				map.put(key, (map.get(key) + 1));
			}
			else{map.put(key, 1); }
		}
		for(Entry<Character, Integer> ent :map.entrySet()) {
			if(ent.getValue()==1 && nonRepeat) {
				nonRepeatChar=ent.getKey();
				nonRepeat=false;
			}else if(ent.getValue()!=1 && repeat) {
				repeatChar=ent.getKey();
				repeat=false;
			}
			if(ent.getValue()>large) {
				large = ent.getValue();
				mostOccuredChar=ent.getKey();
			}
		}
		System.out.println("repeatChar :"+repeatChar + " nonRepeatChar :" +nonRepeatChar + " mostOccuredChar :"+mostOccuredChar);
	}
}
