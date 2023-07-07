package basic.string;

/**
 * Given a string S and text T. Output the smallest window in the string S
 * having all characters of the text T. Both the string S and text T contain
 * only lowercase english alphabets.
 * 
 * Input: Each test/input contains 2 lines: 1st line is the string S and next
 * line is the text T.
 * 
 * Output: Output the smallest window (start and end index) of the S containing
 * all the characters of the T. If such window doesn`t exist or this task cannot
 * be done then print -1.
 *
 * Constraints: 1 <= length(T), length(S) <= 100 s= "algbcfghnjlkb"; a- 0 , l-1
 * b-2 , b-4 , n-9, l-10 t="lbn" 2- 10 ,
 * 
 */

public class SmallestSubSequenceWindow {
	public static void main(String args[]) {
		String str = "alaabnalbn";
		String tr = "lbn";
		char[] s = str.toCharArray();
		char[] t = tr.toCharArray();
		String min = x(str, tr);
		System.out.println(min);
	}

	private static String x(String s, String p) {
		if (p.length() > s.length())
            return null;
        int[] pCount = new int[256];
        int[] sCount = new int[256];
        // Time: O(p.lenght)
        for(int i=0;i<p.length();i++) {
            pCount[(int)(p.charAt(i))]++;
            sCount[(int)(s.charAt(i))]++;
        }
        int i = 0, j = p.length(), min = Integer.MAX_VALUE;
        String res = null;
        // Time: O(s.lenght)
        while (j < s.length()) {
            if (containsPatternChar(sCount, pCount)) {
                if ((j - i) < min) {
                    min = j - i;
                    res = s.substring(i, j);
                    // This is the smallest possible substring.
                    if(min==p.length())
                        break;
                    // Reduce the window size.
                    sCount[(int)(s.charAt(i))]--;
                    i++;
                }
            } else {
                sCount[(int)(s.charAt(j))]++;
                // Increase the window size.
                j++;
            }
        }
        System.out.println(res);
        return res;
	}
	private static boolean containsPatternChar(int[] sCount, int[] pCount) {
        for(int i=0;i<256;i++) {
            if(pCount[i]>sCount[i])
                return false;
        }
        return true;
    }
}
