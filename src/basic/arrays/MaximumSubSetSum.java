package basic.arrays;

public class MaximumSubSetSum {
	static int maxSubsetSum(int[] arr) {
		 if (arr.length == 0) 
			 return 0;
		    arr[0] = Math.max(0, arr[0]);
		 if (arr.length == 1) 
			 return arr[0];
		 arr[1] = Math.max(arr[0], arr[1]);
		 for (int i = 2; i < arr.length; i++)
		      arr[i] = Math.max(arr[i-1], arr[i]+arr[i-2]);
		 return arr[arr.length-1];

    }
	public static void main(String args[]) {
		int arr[] = new int[] { 60, 100, 120,-90 , 10, 20, 200 };
		//o/p = 180
		System.out.println(maxSubsetSum(arr));
	}
}
