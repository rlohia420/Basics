package basic.string;

public class ReverseStringWithoutUsingExtraMemeory {

	public static void main(String args[]) {
		String str = "Nehalohia";
		int length = str.length();
		for(int i=str.length()-1;i>=0;i--) {
			str = str+str.charAt(i);
		}
		System.out.println(str.substring(length));
	}
}
