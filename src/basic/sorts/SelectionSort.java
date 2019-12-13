package basic.sorts;

import java.util.Arrays;

public class SelectionSort {
	/*Compare first and second,
	 * first and third , first and fourth and so on.
	*/
	
	public static void main(String args[]) {
		int[] a = {23,87,45,65,11,9,33};
		int n = a.length;
		int temp =0;
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				if(a[i]>a[j]) {
					temp = a[j];
					a[j] = a[i];
					a[i]= temp;
				}
			}
		}
		Arrays.stream(a).forEach(x->System.out.print(x + " "));
	}
}
