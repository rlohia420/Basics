package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Unique element should be there to make the sum
public class CombinationSum2 {
    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;

    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    public static void main(String args[]){
        int[] arr1= {2,3,6,7}; int target1 = 7;
        int[] arr2={2,3,5}; int target2 = 8;
        int[] arr3={10,1,2,7,6,1,5}; int target3 = 8;
        List<List<Integer>> subset  = combinationSum2(arr1, target1);
        for(List<Integer> ll: subset){
            System.out.println(ll);
        }
    }
}
