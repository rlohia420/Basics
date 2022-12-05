package basic.arrays;

/*
 * Given two arrays A[] and B[] of size N and M respectively, where each element is in the range [0, 9], the task is to make each element of the array A[] strictly greater than or smaller than every element in the array B[] by changing any element from either array to any number in the range [0, 9],
 * minimum number of times.
 */

public class MinimizeReplacementsToMakeEveryElementInAnArrayExceedEveryElementInAnotherGivenArray {

	public static void main(String args[]) {
		int A[] = {0, 0, 1, 3, 3}, B[] = {0, 2, 3};  
		System.out.println(minimumReplacement(A,B));
	}
	
	public static int minimumReplacement(int[] a, int[] b) {
		int max = Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++) {
			max = Math.max(max, a[i]);
		}
		int count =0;
		for(int i=0;i<b.length;i++) {
			if(b[i]<max+1) {
				count++;
			}
		}
		return count;
	}
}
