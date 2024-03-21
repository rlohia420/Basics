package basic.string;

public class LargestPallindrom {

	public static void main(String args[]) {
		largestPallingrom("2345465");
	}
	private static void largestPallingrom(String str) {
		String largest ="";
		for(int i=0;i<str.length();i++) {
			for(int j=str.length();j>=0 && j!=i;j--) {
				String subString = str.substring(i, j);
				if(isPallindrom(subString)) {
					if(subString.length()>largest.length()) {
						largest = subString;
					}
				}
			}
		}System.out.println(largest);
	}
	private static boolean isPallindrom(String str) {
		String reverse ="";
		for(int i=str.length()-1;i>=0;i--) {
			reverse = reverse+str.charAt(i);
		}
		return reverse.equals(str);
	}
}
