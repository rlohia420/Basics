package basic.arrays;

public class PrintAllSubsetsCountWithGivenSum {

    static int count;
    static int sum;
    static int n;
     
    // Driver code
    public static void main (String[] args) {
        count = 0;
        n = 5;
        sum = 10;
 
        int[] pat = {1, 2, 3, 4, 5};
         
        f(pat, 0, 0);
         
        System.out.println(count);
    }
     
    // Function to select or not the array element
    // to form a subset with given sum
    static void f(int[] pat, int i, int currSum) {
        if (currSum == sum) {
            count++;
            return;
        }
        if (currSum < sum && i < n) {
            f(pat, i+1, currSum + pat[i]);
            f(pat, i+1, currSum);
        }
    }
}
