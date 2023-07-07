package basic.string;

import java.util.HashSet;
import java.util.Set;

public class PalindromicSubstrings {

	public static void main(String args[]) {
		Set<String> pallinDrome = new HashSet<>();
		String str = "abcbc";
		int n = str.length();
		for(int i=0;i<=n;i++) {
			for(int j=i+1;j<=n;j++) {
				if(isPallindrom(str.substring(i,j))) {
					System.out.println(str.substring(i,j));
					pallinDrome.add(str.substring(i,j));
				}
			}
		}
		System.out.println(pallinDrome.size());
		
		
		findPalindromicSubstrings(str);
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
	private static boolean isPallindromOther(String str) {
		String reverse ="";
		for(int i=str.length()-1;i>=0;i--) {
			reverse = reverse+str.charAt(i);
		}
		return reverse.equals(str);
	}
	
	public static void expand(String str, int low, int high, Set<String> set)
    {
        // run till `str[low.high]` is not a palindrome
        while (low >= 0 && high < str.length()
                && str.charAt(low) == str.charAt(high))
        {
            // push all palindromes into a set
            set.add(str.substring(low, high + 1));
 
            // Expand in both directions
            low--;
            high++;
        }
    }
 
    // Function to find all unique palindromic substrings of a given string
    public static void findPalindromicSubstrings(String str)
    {
        // base case
        if (str == null) {
            return;
        }
 
        // create an empty set to store all unique palindromic substrings
        Set<String> set = new HashSet<>();
 
        for (int i = 0; i < str.length(); i++)
        {
            // find all odd length palindrome with `str[i]` as a midpoint
            expand(str, i, i, set);
 
            // find all even length palindrome with `str[i]` and `str[i+1]`
            // as its midpoints
            expand(str, i, i + 1, set);
        }
 
        // print all unique palindromic substrings
        System.out.print(set);
    }
}
