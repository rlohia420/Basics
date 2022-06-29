package basic.search;

public class SearchInsert {
//Given a sorted array of distinct integers and a target value, return the index if the target is found. 
	//If not, return the index where it would be if it were inserted in order.

	public static int searchInsert(int[] nums, int target) {
		int start =0;
		int end = nums.length;
		int mid=-1;
		while(start<end) {
			mid = (start+end)/2;
			if(nums[mid]==target) {
				return mid;
			}else if(nums[mid] < target){
				start = ++mid;
			}else {
				end = --mid;
			}
		}
		return mid==-1?0:mid;
	}
	
	public static void main(String args[]) {
		int[] nums = {1,3,4,5,6,7,8,2}; int target = 5;
		System.out.println(searchInsert(nums,target));
	}
}
