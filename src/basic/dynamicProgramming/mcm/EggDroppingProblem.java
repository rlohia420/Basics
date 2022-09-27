package basic.dynamicProgramming.mcm;
//https://www.youtube.com/watch?v=S49zeUjeUL0&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=42
public class EggDroppingProblem {
	static int eggDrop(int e, int f)
    {
        // If there are no floors, then
        // no trials needed. OR if there
        // is one floor, one trial needed.
        if (f == 1 || f == 0)
            return f;
 
        // We need k trials for one egg
        // and k floors
        if (e == 1)
            return f;
 
        int min = Integer.MAX_VALUE;
        int res;
 
        // Consider all droppings from
        // 1st floor to kth floor and
        // return the minimum of these
        // values plus 1.
        for (int i = 1; i <= f; i++) {
            res = 1+ Math.max(eggDrop(e - 1, i - 1),
                           eggDrop(e, f - i));
            min = Math.min(min, res);
        }
 
        return min;
    }
 
    // Driver code
    public static void main(String args[])
    {
        int n = 2, k = 10;
        System.out.print("Minimum number of "
                         + "trials in worst case with "
                         + n + " eggs and " + k
                         + " floors is " + eggDrop(n, k));
    }
    // This code is contributed by Ryuga.

}
