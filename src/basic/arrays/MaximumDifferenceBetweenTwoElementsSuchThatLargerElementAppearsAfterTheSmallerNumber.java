package basic.arrays;


public class MaximumDifferenceBetweenTwoElementsSuchThatLargerElementAppearsAfterTheSmallerNumber {

	public static void main(String args[]) {
		int[] arr = {2, 3, 10, 6, 4, 8, 1};
		System.out.println(maxDiff(arr));
	}
	public static int maxDiff(int[] arr) {
		int max = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++) {
				max = Math.max(arr[j]-arr[i] , max);
			}
		}
		return max;
	}
}
