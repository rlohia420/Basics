package basic.string;

import java.util.HashSet;
import java.util.Set;

public class StringSort {

	public static void main(String args[]) {
		sortString("LKJHGF");
		removeACharacter("NehaLohia");
		ifStringContainsAnother("NehaLohiaGarg","Lohia");
		ifStringContainsAnother("NehaLohiaGarg","Lohis");
		getRepeatingChar("NehaLohia");
	}
	private static void sortString(String str) {
		char[] a = str.toCharArray();
		for(int i=0;i<a.length;i++) {
			for(int j=i+1;j<a.length;j++) {
				Character temp = a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
		System.out.println(a);
	}
	private static void removeACharacter(String str) {
		System.out.println(str.replace("a",""));
	}
	private static void ifStringContainsAnother(String fullString,String subString) {
		boolean contains = (fullString.indexOf(subString)!=-1)?true:false;
		System.out.println(contains);
	}
	private static void getRepeatingChar(String str) {
		char[] a = str.toCharArray();
		Set<Character> set = new HashSet<>();
		for(int i=0;i<a.length;i++) {
			if(!set.add(a[i])) {
				System.out.println(a[i]);
			}
		}
	}
}
