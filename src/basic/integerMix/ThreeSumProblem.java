package basic.integerMix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSumProblem {
	private static List<Integer[]> findThreeSum(int[] nums, int target) {
	    List<Integer[]> result = new ArrayList<>();
	    for (int i = 0; i < nums.length; i++) {
	      int currentTarget = target - nums[i];
	      Set<Integer> existingNums = new HashSet<>();
	      for (int j = i + 1; j < nums.length; j++) {
	        if (existingNums.contains(currentTarget - nums[j])) {
	          result.add(new Integer[] { nums[i], nums[j], currentTarget - nums[j] });
	        } else {
	          existingNums.add(nums[j]);
	        }
	      }
	    }
	    return result;
	  }
	
	public static void main(String args[]) {
		int[] arr = {7, 12, 3, 1, 2, -6, 5, -8, 6};
		int sum=0;
		List<Integer[]> list= findThreeSum(arr,sum);
		for(Integer[] inn : list) {
			for(int i=0;i<inn.length;i++) {
				System.out.print(inn[i] + ",");
			}
			System.out.println("");
		}
	}
}
