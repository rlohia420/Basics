package basic.string;

import java.util.HashSet;
import java.util.Set;

public class BasicStringOperations {

	public static void main(String args[]) {
		//remove a given character from string
		System.out.println("**remove a given character from string**");
		String str = "Neha";
		System.out.println(str.replaceAll("a",""));
		
		System.out.println("**Check if one string contains another**");
		String str1 = "Nehalohia"; String str2="lohia";
		System.out.println("String "+str1+" expected to contains "+str2 +":"+(str1.indexOf(str2)!=-1));
		
		System.out.println("** print all the repeating character**");
		int[] a = {1,2,3,45,3,2,5,6,45};
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<a.length;i++) {
			if(!set.add(a[i]))
			System.out.println(a[i]);
		}
		
		System.out.println("** print Second largest element**");
		int[] arr = {15,19,5,18,30,40,20};
		int temp=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					temp = arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.println("second largest :: "+arr[arr.length-2]);
	}
}
