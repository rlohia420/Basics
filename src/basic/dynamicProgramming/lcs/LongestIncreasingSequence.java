package basic.dynamicProgramming.lcs;

public class LongestIncreasingSequence {
    public static void main(String args[]){
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;
        // Function call
        System.out.println("Length of LIS is "
                + LIS(arr, n));
    }
    private static int LIS(int[] arr, int n){
        int max = Integer.MIN_VALUE;
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            dp[i] =1;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i] > arr[j] && dp[i] <dp[j]+1){
                    dp[i] = dp[j]+1;
                }
            }
        }
        for(int i=0;i<n;i++){
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
