package basic.arrays;

import java.util.HashSet;
import java.util.Set;

public class FindTheElementThatAppearsOnceInAnArrayWhereEveryOtherElementAppearsTwice {
	public static void main(String args[]) {
		int[] arr = {2, 3, 5, 4, 5, 3, 4};
		uniqueElement(arr);
	}
	public static void uniqueElement(int[] arr) {
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<arr.length;i++) {
			if(!set.add(arr[i])) {
				set.remove(arr[i]);
			}
		}
		if(set.iterator().hasNext()) {
			System.out.println(set.iterator().next());
		}
	}
}
