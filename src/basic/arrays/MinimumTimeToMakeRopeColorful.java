package basic.arrays;

/*
 * In the problem, we are given a string colors representing a rope of balloons,
 *  and an array neededTime for the removal time of each corresponding balloon. 
 *  We need to remove some (could be none) of the balloons from the rope,
 *   so that there are no two consecutive balloons on the rope that have the same color,
 *    as shown in the picture below.Recall that each balloon has a removal time, 
 *    our task is to find the minimum total removal time among all such possible removing plans.
 */
public class MinimumTimeToMakeRopeColorful {
	public static void main(String args[]) {
		String c = "aaabbbabbbb";
		int[] n = { 3, 5, 10, 7, 5, 3, 5, 5, 4, 8, 1 };
		// o/p - 3

		int minTime = getMinNDelete(c, n);
		System.out.println(minTime);
	}

	public static int getMinNDelete(String colors, int[] neededTime) {//ababbbb
		 int n = neededTime.length;
	        int i=0;
	        int j=1;
	        int res = 0;
	        while(i<n && j<n){
	            if(colors.charAt(i) == colors.charAt(j)){
	                if(neededTime[i] <= neededTime[j]){
	                    res+=neededTime[i];
	                    i=j;j++;
	                }
	                else{
	                    res+=neededTime[j];
	                    j++;
	                }
	            }
	            else{
	                i=j;j++;
	            }
	        }
	        return res;
	}
}
