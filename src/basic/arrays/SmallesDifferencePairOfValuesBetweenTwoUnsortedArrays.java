package basic.arrays;

import java.util.Arrays;

public class SmallesDifferencePairOfValuesBetweenTwoUnsortedArrays {
/*
 * Consider the following two arrays:
A: {l, 2, 11, 15}
B: {4, 12, 19, 23, 127, 235}

1. Suppose a pointer a points to the beginning of A and a pointer b points to the beginning of B. The current difference between a and bis 3. Store this as the min.

2. How can we (potentially) make this difference smaller? Well, the value at bis bigger than the value at a, so moving b will only make the difference larger. Therefore, we want to move a.

3. Now a points to 2 and b (still) points to 4. This difference is 2, so we should update min. Move a, since it is smaller.

4. Now a points to 11 and b points to 4. Move b.

5. Now a points to 11 and b points to 12. Update min to 1. Move b. And so on.
 */
	
	// function to calculate Small 
    // result between two arrays
    static int findSmallestDifference(int A[], int B[],
                                      int m, int n)
    {
        // Sort both arrays 
        // using sort function
        Arrays.sort(A);
        Arrays.sort(B);
        int a = 0, b = 0;
        // Initialize result as max value
        int result = Integer.MAX_VALUE;
        // Scan Both Arrays upto 
        // sizeof of the Arrays
        while (a < m && b < n){
            if (Math.abs(A[a] - B[b]) < result)
                result = Math.abs(A[a] - B[b]);
            // Move Smaller Value
            if (A[a] < B[b])
                a++;      
            else
                b++;
        }
        // return final sma result
        return result; 
    }
      
    // Driver Code
    public static void main(String[] args) 
    {
        // Input given array A
        int A[] = {1, 2, 11, 5};
        // Input given array B
        int B[] = {4, 12, 19, 23, 127, 235};
        // Calculate size of Both arrays
        int m = A.length;
        int n = B.length;
        // Call function to 
        // print smallest result
        System.out.println(findSmallestDifference(A, B, m, n));
    }
}
