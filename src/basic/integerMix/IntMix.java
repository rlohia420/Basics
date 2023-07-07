package basic.integerMix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntMix {

	public static void main(String args[]) {
		System.out.println("====Fabnocci====");
		fabnocci();
		System.out.println("====power====");
		power(3,6);
		System.out.println("====factorial====");
		factorial(6);
		System.out.println("====isPerfact====");
		isPerfact(6);
		System.out.println("====sumOfEachDigit====");
		sumOfEachDigit(692);
		int[] arr = {2,2,1};
		defangingIPAddress("1.1.1.1");
	}
	private static void fabnocci() {
		int[] f = new int[10];
		f[0]=0; f[1]=1;
		for(int j=2;j<10;j++) {
			f[j]=f[j-1]+f[j-2];
			System.out.println(f[j]);
		}
	}
	private static void power(int x, int n) {
		int result=1;
		for(int i=1;i<=n;i++) {
			result = result*x;
		}
		System.out.println(result);
	}
	private static void factorial(int n) {
		int result=1;
		for(int i=n;i>1;i--) {
			result = result*i;
		}
		System.out.println(result);
	}
	private static void isPerfact(int n) {
		int temp=0;
		for(int i=1;i<=n/2;i++) {
			if(n%i==0) {
				temp+=i;
			}
		}
		System.out.println((temp==n)?("perfect"):"Not a perfact number");
	}
	private static void sumOfEachDigit(int n) {
		int sum =0; int mod=0;
		while(n>0) {
			mod = n%10;
			sum =sum+mod;
			n=n/10;
		}
		System.out.println(sum);
	}
	public static void defangingIPAddress(String address) {
		System.out.println(address.replace(".","[.]"));
	}
}
