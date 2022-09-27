package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuildingsWithAnOceanView_1762 {

	public static void main(String args[]) {
		int[] a = { 2, 2, 2 };
		List<Integer> list = Arrays.asList(2, 2, 2);
		Set<Integer> set = new HashSet<>(list);
		if (set.size() == 1) {
			System.out.println(a.length - 1);
		} else {
			List<Integer> result = new ArrayList<>();
			for (int i = 0; i < a.length; i++) {
				boolean flag = false;
				for (int j = a.length - 1; j > i; j--) {
					if (a[i] < a[j]) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					result.add(i);
				}

			}
			for (int i = 0; i < result.size(); i++) {
				System.out.println(result.get(i));
			}
		}
	}
}
