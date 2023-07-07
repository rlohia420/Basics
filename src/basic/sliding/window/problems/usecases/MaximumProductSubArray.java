package basic.sliding.window.problems.usecases;

public class MaximumProductSubArray {

	public static void main(String args[]) {
		int[] a = { 6, -3, -10, 0, 2, 91 };
		int i = 0, j = 0, n = a.length;
		int prod = 1;
		int max = Integer.MIN_VALUE;
		int start = 0, end = 0;
		while (j < n) {
			int pre = prod;
			prod = prod * a[j];
			if (prod > max) {
				max = prod;
				start = i;
				end = j;
				j++;
			} else {
				if (a[i] != 0)
					prod = prod / a[i];
				j++;
				i++;
			}
		}
		System.out.println("start = " + start + " end =" + end);
	}
}
