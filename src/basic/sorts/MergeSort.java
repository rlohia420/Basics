package basic.sorts;

public class MergeSort {

	public static void main(String args[]) {
		int[] arr = {12, 11, 13,80, 5, 6, 7}; 
		System.out.println("Given Array");
		 for(int i=0;i<arr.length;i++)
        System.out.print(arr[i] + " ");
 
        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);
 
        System.out.println("\nSorted array");
        for(int i=0;i<arr.length;i++)
        System.out.print(arr[i]+" ");
	}
	
	public void sort(int[] arr, int l , int r) {
		if(l<r) {
			int m = (l+r)/2;
			sort(arr,l,m);
			sort(arr,m+1,r);
			merge(arr, l, m, r);
		}
	}
	
	public void merge(int[] arr , int l, int m, int r) {
		int n1 = m-l+1;
		int n2 = r-m;
		int[] leftArr = new int[n1];
		int[] rightArr = new int[n2];
		for(int i=0;i<n1;i++) {
			leftArr[i] = arr[l+i] ;
		}
		for(int i=0;i<n2;i++) {
			rightArr[i] = arr[m+1+i] ;
		}
		int i=0 , j=0,k=l;
		while(i<n1 && j<n2) {
			if(leftArr[i] < rightArr[j]) {
				arr[k] = leftArr[i]; i++;
			}else {
				arr[k] = rightArr[j]; j++;
			}
			k++;
		}
		while (i < n1) {
            arr[k] = leftArr[i]; i++;k++;
        }
		while (j < n2) {
            arr[k] = rightArr[j]; j++;k++;
        }
	}
	
	
}
