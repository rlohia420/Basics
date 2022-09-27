package basic.search;

public class SearchAnElementInASortedAndRotatedArray {
	
    static int search(int arr[], int l, int h, int key) {
        if (l > h)
            return -1;
        int mid = (l + h) / 2;
        if (arr[mid] == key)
            return mid;
        if (arr[l] <= arr[mid]) {
            if (key >= arr[l] && key <= arr[mid])
                return search(arr, l, mid - 1, key);
            return search(arr, mid + 1, h, key);
        }
        if(arr[mid]<arr[h]) {
	        if (key >= arr[mid] && key <= arr[h])
	            return search(arr, mid + 1, h, key); 
	        return search(arr, l, mid - 1, key);
        }
        return -1;
    }
 
    public static void main(String args[])
    {
        //int arr[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
        int[] arr = {30,40,50,5,10,15,20,25};
        int n = arr.length;
        int key = 20;
        int i = search(arr, 0, n - 1, key);
        if (i != -1)
            System.out.println("Index: " + i);
        else
            System.out.println("Key not found");
    }
    
}
