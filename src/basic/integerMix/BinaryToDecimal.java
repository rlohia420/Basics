package basic.integerMix;

public class BinaryToDecimal {
	static int binaryToDecimal(int n) {
		int num = n;
		int dec_value = 0;
		// Initializing base
		// value to 1, i.e 2^0
		int base = 1;

		for(int temp = num;temp>0 ; temp=temp/10) {
			int last_digit = temp % 10;
			dec_value += last_digit * base;
			base = base * 2;
		}
		return dec_value;
	}

	// Driver Code
	public static void main(String[] args) {
		//int num = 10101001;
		int num = 101;
		System.out.println(binaryToDecimal(num));
	}
}
