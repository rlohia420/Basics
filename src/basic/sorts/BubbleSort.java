package basic.sorts;

import java.util.Arrays;

public class BubbleSort {

	/*Compare first and second,
	 * second and third , third and fourth and so on.
	*/
	public static void main(String args[]) {
		int[] a = {23,87,45,65,11,9,33};
		int n = a.length;
		int temp =0;
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<(n-i-1);j++) {
				if(a[j]>a[j+1]) {
					temp = a[j];
					a[j] = a[j+1];
					a[j+1]= temp;
				}
			}
		}
		Arrays.stream(a).forEach(x->System.out.print(x + " "));
	}
}
