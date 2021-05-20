package basic.scenarios;

import java.util.Arrays;

public class MinPlatform {

	public static int findPlatform(int[] arr , int[] dep , int n) {
		Arrays.sort(arr);
		Arrays.sort(dep);
		int platformNeeded =1;
		int result =1;
		int i=1, j=0;
		while(i<n && j<n) {
			if(arr[i] <= dep[j]) {
				platformNeeded++; i++;
				if(platformNeeded > result ) {
					result = platformNeeded;
				}else {
					platformNeeded--; j++;
				}
			}
		}
		return result;
	}
}
