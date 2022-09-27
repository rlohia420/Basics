package basic.sliding.window.problems;

import java.util.LinkedList;
import java.util.List;

public class MaximumOfAllsubArrayOfWindowSizeK_FW_5 {

	public static void main(String args[]) {
		//int [] arr = {4,3,-1,6,5,3,8,7}; //o/p : {3,3,5,5,6,7} need to fid out the maximum element in all suArray
		int[] arr = {12, 35, 1, 10, 34, 190 ,6,98};
		int k=3;
		maximumSubarray(arr,k).stream().forEach(x->System.out.println(x));
	}
	private static List<Integer> maximumSubarray(int[] arr , int k) {
		int i=0, j=0;
		List<Integer> output = new LinkedList<>();
		int size=arr.length;
		int max =arr[i];
		while(j<size) {
			int secondMax = arr[i+1]; // this second max element is needed when max element was falling in previous window
			max = Math.max(max,arr[j]);
			if(j-i+1 < k) {
				j++;
			}else if(j-i+1 ==k) {
				output.add(max);
				if(max == arr[i]) {
					max = secondMax;
				}
				i++;j++;
			}
		}
		return output;
	}
}
