package basic.arrays;

public class MedianOfTwoSortedArrays {
	public static double median(int[] a, int[] b) {
		int length = a.length!=0 && b.length!=0 ? a.length+b.length
					:a.length==0 && b.length!=0 ? b.length :a.length!=0 && b.length==0 ? a.length :0;
    	int[] result = new int[length];
    	if(a.length==length) {
    		result = a;
    	}else if(b.length==length) {
    		result = b;
    	}else {
    		int k=0; int i=0 ,j=0;
    		while( i<a.length && j<b.length) {
    			if(a[i]<b[j]) {
    				result[k] = a[i];
    				i++;
    			}else {
    				result[k] = b[j];
    				j++;
    			}k++;
    		}
    		while(i<a.length) {
    			result[k++] = a[i++];
    		}
    		while(j<b.length) {
    			result[k++] = b[j++];
    		}
    	}
    	if(result.length%2!=0) {
    		return result[(result.length)/2];
    	}else {
    		double x = (result[(result.length-1)/2] + result[(result.length-1)/2+1]);
    		return  x/2;
    	}
    }
	
	public static void main(String argsp[]) {
		int  a[]= {1,2,3,4};
		int b[]= {5,6,7,8};
		System.out.println(median(a,b));
	}
}
