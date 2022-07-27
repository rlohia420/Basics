package basic.string;

public class AnagramOfString {

	public static void main(String args[]) {
		System.out.println(permutation("abs","sba123"));
		
		System.out.println(replaceFunction("Neha Lohia"));
	}
	private static boolean permutation(String s1 , String s2) {
		if(s1.length()!=s2.length()) {
			return false;
		}else {
			int[] letters = new int[128];
			for(Character c: s1.toCharArray()) {
				letters[c]++;
			}
			for(Character c: s2.toCharArray()) {
				letters[c]--;
				if(letters[c] != 0) {
					return false;
				}
			}
			
		}
		return true;
	}
	
	private static String replaceFunction(String str) {

		int emptyCharacter =0;
		int length = str.length();
		for(char a :str.toCharArray()) {
			if(a==' ') {
				emptyCharacter++;
			}
		}
		int newStringLength = emptyCharacter*2 + length;
		char[] charA = new char[newStringLength];
		for(int i=length-1;i>=0;i--) {
			if(str.charAt(i)==' ') {
				charA[newStringLength-1] = '0';
				charA[newStringLength-2]  = '2';
				charA[newStringLength-3]  = '%';
				newStringLength = newStringLength-3;
			}else {
				charA[newStringLength-1] =str.charAt(i);
				newStringLength--;
			}
		}
		return new String(charA);
	}
}
