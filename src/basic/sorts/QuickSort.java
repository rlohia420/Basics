package basic.sorts;

import java.util.Arrays;

public class QuickSort {
	public static void main(String args[]) {
		int[] a = {23,87,45,65,11,9,33};
		Arrays.stream(quickSort(a,0,a.length-1)).forEach(x->System.out.println(x));
	}
	private static int[] quickSort(int[] arr,int low,int high) {
		int i=low,j=high;
		int pivot = arr[(i+j)/2];
		while(i<=j) {
			while(arr[i]<pivot) {
				i++;
			}
			while(arr[j]>pivot) {
				j--;
			}
			if(i<=j) {
				int temp = arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				i++;j--;
			}
		}
		if(low<j) {
			quickSort(arr, low, j);
		}if(i<high) {
			quickSort(arr,i,high);
		}
		return arr;
	}
}
