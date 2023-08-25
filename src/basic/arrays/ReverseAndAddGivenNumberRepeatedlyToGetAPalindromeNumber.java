package basic.arrays;

public class ReverseAndAddGivenNumberRepeatedlyToGetAPalindromeNumber {

	public static void main(String args[]) {
		//inout - 195 , output = 9339
		int input = 294;
		int result = input;
		result(result,input);
	}
	private static int reverse(int num) {
		String result = "";
		while(num>0) {
			int x = num%10;
			result =result + x;
			num = num/10;
		}
		return Integer.parseInt(result);
	}
	private static boolean isPallindrome(int num) {
		int reverse = reverse(num);
		return reverse ==num;
	}
	private static void result(int result ,int input) {
		while(!isPallindrome(result)) {
			if(result <= 4294967295L )
				result = (result + reverse(result));
		}
		System.out.println(result==input?"No palindrome exist":result);

	}
}
