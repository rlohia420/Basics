package basic.dynamicProgramming.level1;
//https://www.geeksforgeeks.org/minimize-steps-to-reach-k-from-0-by-adding-1-or-doubling-at-each-step/
public class MinOperation {
    static int minOperation(int k)
    {
        // dp is initialised
        // to store the steps
        int dp[] = new int[k + 1];

        for(int i = 1; i <= k; i++)
        {
            dp[i] = dp[i - 1] + 1;

            // For all even numbers
            if (i % 2 == 0)
            {
               int x = dp[i/2];
                if(x+1 < dp[i]){
                    dp[i] = x+1;
                }
            }
        }
        return dp[k];
    }

    // Driver Code
    public static void main (String []args)
    {
        int K = 12;
        System.out.print( minOperation(K));
    }

    private static int minOperation1(int n){
        //https://www.geeksforgeeks.org/minimize-operations-required-to-obtain-n/
        // Storing the minimum operations
        // to obtain all numbers up to N
        int dp[] = new int[n + 1];

        // Initial state
        dp[1] = 0;

        // Iterate for the remaining numbers
        for(int i = 2; i <= n; i++)
        {
            dp[i] = Integer.MAX_VALUE;

            // If the number can be obtained
            // by multiplication by 2
            if (i % 2 == 0)
            {
                int x = dp[i / 2];
                if (x + 1 < dp[i])
                {
                    dp[i] = x + 1;
                }
            }

            // If the number can be obtained
            // by multiplication by 3
            if (i % 3 == 0)
            {
                int x = dp[i / 3];
                if (x + 1 < dp[i])
                {
                    dp[i] = x + 1;
                }
            }

            // Obtaining the number by adding 1
            int x = dp[i - 1];
            if (x + 1 < dp[i])
            {
                dp[i] = x + 1;
            }
        }

        // Return the minm operations
        // to obtain n
        return dp[n];
    }
}
