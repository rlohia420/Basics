package basic.sorts;

import java.util.Arrays;

public class InsertionSort {

	/*Compare second and first,
	 * third and second , third and first and so on.
	*/
	
	public static void main(String args[]) {
		int[] a = {23,87,45,65,11,9,33};
		int n = a.length;
		int temp =0;
		for(int i=1;i<n;i++) {
			for(int j=i;j>0;j--) {
				if(a[j-1]>a[j]) {
					temp = a[j-1];
					a[j-1] = a[j];
					a[j]= temp;
				}
			}
		}
		Arrays.stream(a).forEach(x->System.out.print(x + " "));
	}

}
