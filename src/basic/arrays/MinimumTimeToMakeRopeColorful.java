package basic.arrays;

public class MinimumTimeToMakeRopeColorful {
	public static void main(String args[]) {
		String c = "aaabbbabbbb";
		int[] n = { 3, 5, 10, 7, 5, 3, 5, 5, 4, 8, 1 };
		// o/p - 3

		int minTime = getMinNDelete(c, n);
		System.out.println(minTime);
	}

	public static int getMinNDelete(String colors, int[] neededTime) {//ababbbb
		int totalTime = 0;
        int i = 0, j = 0;
        
        while (i < neededTime.length && j < neededTime.length) {
            int currTotal = 0, currMax = 0;
            
            // Find all the balloons having the same color as the 
            // balloon indexed at i, record the total removal time 
            // and the maximum removal time.
            while (j < neededTime.length && colors.charAt(i) == colors.charAt(j)) {
                currTotal += neededTime[j];
                currMax = Math.max(currMax, neededTime[j]);
                j++;
            }
            
            // Once we reach the end of the current group, add the cost of 
            // this group to total_time, and reset two pointers.
            totalTime += currTotal - currMax;
            i = j;
        }
        return totalTime;    
	}
}
