package basic.integerMix;

public class LargestAndSmallestNum {

	public static void main(String args[]) {
		int[] a= {12,32,22,54,34,90,54,31};
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<a.length-1;i++) {
			if(a[i]>max) {
				max = a[i];
			}
			if(a[i]<min) {
				min = a[i];
			}
		}
		System.out.println("min : "+min +" max :"+max);
	}
}
