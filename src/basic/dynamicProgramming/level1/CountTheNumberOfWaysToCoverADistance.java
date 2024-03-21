package basic.dynamicProgramming.level1;

public class CountTheNumberOfWaysToCoverADistance {
    //https://www.geeksforgeeks.org/top-50-dynamic-programming-coding-problems-for-interviews/
    //https://www.geeksforgeeks.org/count-number-of-ways-to-cover-a-distance/

    public static void main(String args[]){
        int n = 5;
        //since we need to count the ways in 3 steps so consider this as options to make 4
        int[] arr ={1,2,3};
        System.out.println(countSteps(arr,n));
    }
    private static int countSteps(int[] arr , int sum){
        int[][] dp = new int[arr.length+1][sum+1];
        int n = arr.length;
        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(j==0){
                    dp[i][j]=1;
                }else if(i==0){
                    dp[i][j]=0;
                }else if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j] +dp[i][j-arr[i-1]];
                }else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
}
