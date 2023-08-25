package basic.arrays;

public class IsPallindrome {
	public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        String s = reverse(x);
        return Integer.parseInt(s)==x;  
    }
    private static String reverse(int x){
        String y="";
        while(x>0){
            int i = x%10;
            x=x/10;
            y=y+i;
        }
        System.out.println("y = "+y);
        return y;
    }
    public static void main(String args[]) {
    	System.out.println(isPalindrome(121));
    }
}
