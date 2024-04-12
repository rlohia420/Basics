package backtracking;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
    public static List<List<Character>> permute(char[] nums) {
        List<List<Character>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private static void backtrack(List<List<Character>> list, List<Character> tempList, char [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String args[]){
        String str ="ABC";
        int count=0;
        char[] arr=str.toCharArray();
        List<List<Character>> subset  = permute(arr);
        for(List<Character> ll: subset){
            System.out.println(ll.toString());
            count++;
        }
        System.out.println(count);
    }
}
