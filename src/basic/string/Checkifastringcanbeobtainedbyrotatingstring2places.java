package basic.string;

public class Checkifastringcanbeobtainedbyrotatingstring2places {
	static boolean isRotated(String str1, String str2)
    {
        if (str1.length() != str2.length())
            return false;
        if(str1.length() < 2)
        {
            return str1.equals(str2);
        }
      
        String clock_rot = "";
        String anticlock_rot = "";
        int len = str2.length();
      
        // Initialize string as anti-clockwise rotation
        anticlock_rot = anticlock_rot +
                        str2.substring(len-2, len) +
                        str2.substring(0, len-2) ;
      
        // Initialize string as clock wise rotation
        clock_rot = clock_rot +
                    str2.substring(2) +
                    str2.substring(0, 2) ;
      
        // check if any of them is equal to string1
        return (str1.equals(clock_rot) ||
                str1.equals(anticlock_rot));
    }
     
	static boolean isRotated(String str1, String str2 , int k) {
		if(str1.length()!=str2.length()) {
			return false;
		}
		int n = str1.length();
		for(int i=0,j=n-k; i<k && j<n ;i++,j++ ) {
			if(str1.charAt(i)!=str2.charAt(j)) {
				return false;
			}
		}
		for(int i=k , j=0;i<n && j<n-k;i++,j++) {
			if(str1.charAt(i)!=str2.charAt(j)) {
				return false;
			}
		}
		return true;
	}
	
    // Driver method
    public static void main(String[] args)
    {
    	//amazon - azonam
    	//amazon - onamaz
        String str1 = "geekase";
        String str2 ="ekasege";
      
        System.out.println(isRotated(str1, str2,2) ?  "Yes"
                              : "No");
    }
}
