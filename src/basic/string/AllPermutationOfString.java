package basic.string;

public class AllPermutationOfString {

	public static int counter =0;
	public static void main(String args[]) {
		perm(" ","Neha");
		System.out.println( "Total number of permutation : "+ counter);
	}
	public static void perm(String perm , String word) {
		if(word.isEmpty()) {
			System.out.println(perm);
			counter++;
		}
		else {
			for(int i=0;i<word.length();i++) {
				perm(perm+word.charAt(i), word.substring(0,i)+word.substring(i+1,word.length()));
			}
		}
	}
}
