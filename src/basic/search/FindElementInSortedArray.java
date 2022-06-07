package basic.search;

public class FindElementInSortedArray {

	public static void main(String args[]) {
		int[] nums = {-1,0,3,5,9,12};
		int target = 9;
		 int start = 0 , end = (int)nums.length-1,mid=-1;
	        while(start<=end){
	            mid = (end+start)/2;
	            if(nums[mid] == target) System.out.println( mid);
	            else if (nums[mid] > target)
	                 end = mid-1;
	            else
	                start = mid+1;
	        }
	        //return  -1;
	}
	
}
