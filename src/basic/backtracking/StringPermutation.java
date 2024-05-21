package basic.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPermutation {
    public static List<String> permute(char[] nums) {
        List<String> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private static void backtrack(List<String> list, List<Character> tempList, char [] nums){
        if(tempList.size() == nums.length){
            list.add(tempList.toString() .substring(1, 3 * tempList.size() - 1)
                    .replaceAll(", ", ""));
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
        List<String> subset  = permute(arr);
        for(String ll: subset){
            //String str1 =ll.toString();
            System.out.println(ll);
            count++;
        }
        System.out.println(count);
    }
}
