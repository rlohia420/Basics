package basic.arrays;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UnionAndIntersectionOfTwoSortedArrays {

	public static void main(String args[])
    {
        int arr1[] = { 1, 4, 5, 8 };
        int arr2[] = { 2, 3,5, 6, 7 };
        int m = arr1.length;
        int n = arr2.length;
        printUnion(arr1, arr2, m, n);
    }
	
	private static void printUnion(int[] a1, int[] a2 , int m , int n) {
		Set<Integer> set = new HashSet<>();
		int i=0, j=0;
		for(;i<a1.length && j<a2.length;) {
			if(a1[i]<a2[j]) {
				set.add(a1[i++]);
			}else {
				set.add(a2[j++]);
			}
		}
		if(i<a1.length) {
			while(i<a1.length)
				set.add(a1[i++]);
		}
		if(j<a2.length) {
			while(j<a2.length)
				set.add(a2[j++]);
		}
		Iterator itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	static void printIntersection(int arr1[], int arr2[], int m, int n)
    {
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (arr1[i] < arr2[j])
                i++;
            else if (arr2[j] < arr1[i])
                j++;
            else {
                System.out.print(arr2[j++] + " ");
                i++;
            }
        }
    }
}
