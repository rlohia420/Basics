package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountOfSubsequence {
   /*private static Set<String> path = new HashSet<>();

    static int numberOfTiles(String str){
        if(str.length()==1)
            return 1;
        dfs("",str);
        return path.size();
    }
    static void dfs(String perm , String word){
        if(perm.length()>0){
            path.add(perm);
            System.out.println(perm);
        }
        for(int i=0;i<word.length();i++){
            dfs(perm+word.charAt(i) , word.substring(0,i)+word.substring(i+1,word.length()));
        }
    }
    public static void main(String args[]){
        String str = "ABC";
        System.out.println(numberOfTiles(str));
    }
    */
   public static List<List<Character>> permute(char[] nums) {
       List<List<Character>> list = new ArrayList<>();
       // Arrays.sort(nums); // not necessary
       backtrack(list, new ArrayList<>(), nums);
       return list;
   }

    private static void backtrack(List<List<Character>> list, List<Character> tempList, char [] nums){
        list.add(new ArrayList<>(tempList));
        for(int i = 0; i < nums.length; i++){
            if(tempList.contains(nums[i])) continue; // element already exists, skip
            tempList.add(nums[i]);
            backtrack(list, tempList, nums);
            tempList.remove(tempList.size() - 1);
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
        System.out.println(count-1);//remove the empty string count

    }
}
