package basic.integerMix;

import java.util.LinkedList;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> res=new LinkedList<>();
        List<Integer> subres=new LinkedList<>();
        boolean flag[]=new boolean[nums.length];
        calculate(nums,flag,res,subres);
        return res;
        
    }
    public static void calculate(int nums[],boolean flag[],List<List<Integer>> res,List<Integer>subres)
    {
        if(subres.size()==nums.length)
        {
            res.add(new LinkedList<>(subres));
            return;
        }
       for(int curr=0;curr<nums.length;curr++)
       {
            if(!flag[curr])
        {
            subres.add(nums[curr]);
                flag[curr]=true;
            calculate(nums,flag,res,subres);
            subres.remove(subres.size()-1);
            flag[curr]=false;
        }
       }
        
    }
}
