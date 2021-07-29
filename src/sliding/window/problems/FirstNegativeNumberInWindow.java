package sliding.window.problems;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeNumberInWindow {

	public static void main(String args[]) {
		int[] arr ={-8, 2, 3, -6, 10};
		int k=2;
		negativeNumber(arr,k);
	}
	private static void negativeNumber(int[] arr ,int k){
		Queue<Integer> queue = new LinkedList<>();
		int i=0,j=0;
		int size = arr.length;
		while(j< size) {
			if(arr[j]<0) {
				queue.add(arr[j]);
			}
			if(j-i+1 < k) {
				j++;
			}else if (j-i+1 == k) {
				if(queue.isEmpty()) {
					System.out.println("0 ");
				}else if (arr[i] == queue.peek()) {
					int s = queue.peek();
					System.out.println(s+"");
				}else {
					System.out.println(queue.peek()+" ");
				}
				i++;j++;
			}
		}
		
	}
}
