package basic.arrays;

import java.util.HashMap;
import java.util.Map;

public class CountSubArrayWithEqualNumberOf0And1 {
	static int countSubarrWithEqualZeroAndOne(int[] arr, int n) {
		Map<Integer, Integer> myMap = new HashMap<>();
		int sum = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
// Replacing 0's in array with -1
			if (arr[i] == 0)
				arr[i] = -1;

			sum += arr[i];

// If sum = 0, it implies number of 0's and 1's
// are equal from arr[0]..arr[i]
			if (sum == 0)
				count++;

			if (myMap.containsKey(sum))
				count += myMap.get(sum);

			if (!myMap.containsKey(sum))
				myMap.put(sum, 1);
			else
				myMap.put(sum, myMap.get(sum) + 1);
		}
		return count;
	}

	public static void main(String[] args) {
		int arr[] = { 0, 1, 0,0, 1,  1, 1 };
		int n = arr.length;
		System.out.println("Count = " + countSubarrWithEqualZeroAndOne(arr, n));
	}
}
