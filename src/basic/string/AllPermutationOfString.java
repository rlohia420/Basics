package basic.string;

public class AllPermutationOfString {

	public static int counter = 0;

	public static void main(String args[]) {
		 perm(" ", "abc");
		//generatePermutation("Neha", 0, "Neha".length());
		System.out.println("Total number of permutation : " + counter);
	}

	public static void perm(String perm, String word) {
		if (word.isEmpty()) {
			System.out.println(perm);
			counter++;
		} else {
			for (int i = 0; i < word.length(); i++) {
				perm(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));
			}
		}
	}

	// backtracking approach
	public static void generatePermutation(String str, int start, int end) {
		// Prints the permutations
		if (start == end - 1) {
			System.out.println(str);
			counter++;
		} else {
			for (int i = start; i < end; i++) {
				// Swapping the string by fixing a character
				str = swapString(str, start, i);
				// Recursively calling function generatePermutation() for rest of the characters
				generatePermutation(str, start + 1, end);
				// Backtracking and swapping the characters again.
				str = swapString(str, start, i);
			}
		}
	}

	public static String swapString(String a, int i, int j) {
		char[] b = a.toCharArray();
		char ch;
		ch = b[i];
		b[i] = b[j];
		b[j] = ch;
		return String.valueOf(b);
	}
}
