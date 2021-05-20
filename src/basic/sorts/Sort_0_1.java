package basic.sorts;

public class Sort_0_1 {

	public static void  main(String args[]) {
		int[] n = { 1, 0, 0, 1, 0, 1 };
		int low = 0;
		int high = (n.length - 1);
		while (low < high) {
			if (n[low] == 1) {
				int temp = n[low];
				n[low]=n[high];
				n[high] =temp;
				high--;
			}else
				low++;
		}
		for(int i=0;i<n.length;i++) {
			System.out.println(n[i]);
		}
	}
}
