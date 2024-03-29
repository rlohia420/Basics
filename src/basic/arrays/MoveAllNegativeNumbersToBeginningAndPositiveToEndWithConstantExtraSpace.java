package basic.arrays;

public class MoveAllNegativeNumbersToBeginningAndPositiveToEndWithConstantExtraSpace {

	public static void swap(int[] ar, int i, int j)
    {
        int t = ar[i];
        ar[i] = ar[j];
        ar[j] = t;
    }
 
    // function to shilf all negative integers to the left
    // and all positive integers to the right
    // using Dutch National Flag Algorithm
    public static void move(int[] ar)
    {
        int low = 0;
        int high = ar.length - 1;
        while (low <= high) {
            if (ar[low] <= 0)
                low++;
            else {
                swap(ar, low, high);
                high--;
            }
        }
    }
 
    // Driver code
    public static void main(String[] args)
    {
        int[] ar = {5,-1,-2,3,2,-4 };
        move(ar);
        for (int e : ar)
            System.out.print(e + " ");
    }
}
