package basic.string;

public class RemoveTheDuplicatesInSpecialWay {
	public static void main(String args[]) {
		String str= "abccbdefffgghhfhklllmmnnlka"; //o/p = adeha
		String result ="";
		int n = str.length();
		char[] charA = str.toCharArray();
		for(int i=0;i<n;i++) {
			Character c = result.length()>0 ? result.charAt(result.length()-1):null; 
			if(c==null) {
				result = result+charA[i];
			}
			else if(c!=null && c!=charA[i]) {
				result+=charA[i];
			}else {
				result = result.substring(0, result.length()-1);
			}
		}
		System.out.println("*******************" );
		System.out.println(result);
	}
}
