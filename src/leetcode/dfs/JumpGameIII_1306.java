package leetcode.dfs;

public class JumpGameIII_1306 {
	 
	public static boolean canReach(int[] arr, int start) {
	        if (start < 0 || start >= arr.length || arr[start] < 0) return false;
	        if (arr[start] == 0) {
	            return true;
	        }
	        int t = arr[start];
	        arr[start] = -1;
	        return canReach(arr, start + t) || canReach(arr, start - t);
	   
	    }
	 public static void main(String args[]) {
		 int[] arr = {3,0,2,1,2};
		 int start = 2;
		 
		 System.out.println(canReach(arr,start));
	 }
}
