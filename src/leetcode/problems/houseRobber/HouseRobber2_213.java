package leetcode.problems.houseRobber;

import java.util.Arrays;

public class HouseRobber2_213 {
	public int rob(int[] nums) {
	    if(nums.length==1)return nums[0];
	    if(nums.length==2) return (nums[0]>nums[1])? nums[0]:nums[1];
		
	    int[] dp =new int[nums.length];
	    Arrays.fill(dp,-1);
		
	    return Math.max(func(dp,nums,0,nums.length-2),func(dp,nums,1,nums.length-1));
	}
	int func(int[] dp, int[] nums,int i, int n){
	    dp[i]=nums[i];
	    dp[i+1]=Math.max(nums[i+1],nums[i]);
		
	    for(int j=i+2;j<=n;j++)
	    {
	        dp[j]=Math.max(dp[j-1],dp[j-2]+nums[j]);
	    }
	    return dp[n];
	}
}
