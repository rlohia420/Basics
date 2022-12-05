package leetcode.string;

public class RemovingStarsFromaString_2390 {
	public static String removeStars(String s) {
		 StringBuilder sbr = new StringBuilder(); // stack for add and removing elements
	        for (char i : s.toCharArray()) { // loop through s
	            if (i=='*' && sbr.length()!=0) {
	            	sbr.deleteCharAt(sbr.length()-1); // if i is a star, then delete the last character
				}
	            else {
	            	sbr.append(i); // if i is not a star, add it to the stack
				}
	        }
	        return sbr.toString();
	}

	public static void main(String args[]) {
		String  s = "leet**cod*e";
		System.out.println(removeStars(s));
	}

}
