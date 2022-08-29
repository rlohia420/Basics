package basic.string;

public class PalindromicSubstrings {

	public static void main(String args[]) {
		String str = "abc";
		int count =0;
		int n = str.length();
		for(int i=0;i<=n;i++) {
			for(int j=i+1;j<=n;j++) {
				if(isPallindrom(str.substring(i,j))) {
					System.out.println(str.substring(i,j));
					count++;
				}
			}
		}
		System.out.println(count);
	}
	private static boolean isPallindrom(String s) {
		//System.out.println(s);
		if(s.isEmpty()) {
			return true;
		}else {
			StringBuffer sbr = new StringBuffer(s);
			return s.equals(new String(sbr.reverse()));
		}
	}
}
