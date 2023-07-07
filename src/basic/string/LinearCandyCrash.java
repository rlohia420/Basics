package basic.string;

public class LinearCandyCrash {

	public static void main(String args[]) {
		String s="axxxsnnnb";
		int k=3;
		System.out.println(candyCrash(s,k));
	}
	private static String candyCrash(String s , int k) {
		String res=s;
		for(int i=0;i<s.length();i++) {
			boolean flag = false;
			for(int j=1;j<=k;j++) {
				if(s.length()>i+j && s.charAt(i)==s.charAt(i+j)) {
					flag =true;
				}
			}
			if(flag) {
				res = res.substring(0,i)+res.substring(i+k,res.length());
				return candyCrash(res,k);
			}
			
		}
		return res;
	}
}
