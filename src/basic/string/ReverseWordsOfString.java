package basic.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWordsOfString {

	public static void main(String argsp[]) {
		String str = "Hello My Name is Neha Lohia";
		//Lohia Neha is Name My Hello 
		List<String> splitted = Arrays.asList(str.split(" "));
		Collections.reverse(splitted);
		StringBuilder sb = new StringBuilder();
		for(String s: splitted) {
			sb.append(s).append(" ");
		}
		System.out.println(sb.toString());
		
		
		//out put = "olleH yM emaN si aheN aihoL"
		String str1 = str;
		List<String> newSplitted = Arrays.asList(str.split(" "));
		StringBuilder sb12 = null;
		StringBuilder sb1 = new StringBuilder();
		for(String ss: newSplitted) {
			sb12=new StringBuilder();
			for(int i=ss.length()-1;i>=0;i--) {
				sb12.append(ss.charAt(i));
			}
			sb1.append(sb12).append(" ");
		}
		System.out.println(sb1);
	}
}
