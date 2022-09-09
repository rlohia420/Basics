package basic.arrays;

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
