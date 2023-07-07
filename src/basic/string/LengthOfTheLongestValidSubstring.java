package basic.string;

import java.util.Stack;

public class LengthOfTheLongestValidSubstring {

	public static void main(String args[]) {
		String str = "((())))))()()()(())";
		int count = 0;
		int max = 0;
		Stack<Character> stack = new Stack();
		stack.push('%');
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				stack.push(str.charAt(i));
			} else if (str.charAt(i) == ')' && !stack.isEmpty()) {
				Character ch = stack.pop();
				if (ch != '%') {
					count = count + 2;
					max = Math.max(max, count);
				}else {
					stack.push('%');
					count=0;
				}
			}
		}
		System.out.println(count);
	}
}
