package basic.string;

public class SwapSequential01 {
	/*
	 * Swap all 01 in the given string and count the number of cycle need to remove all "01"
	 */
	
	public static int count=0;
   public static int getSwapTime(String color ){
       if(!color.contains("01")){
           return count;
       }else{
           for(int i=0, j=1;i<color.length() && j<color.length();i++,j++) {
               if(color.charAt(i)=='0' && color.charAt(j)=='1'){
                   color = (swap(color,i++,j++));
               }
           }
           count= count+1;
           getSwapTime(color);
       }
       return count;
   }
    public static String swap(String str1 , int i , int j){
    	String str = str1;
        String temp = str.substring(0,i) +str.charAt(j) +str.charAt(i)+str.substring(j+1,str.length());
        System.out.println(temp);
        return temp;
    }
    public static void main(String args[]) {
    	String str = "001011"; //-> 1001 -> 1010 -> 1100
    	System.out.println(getSwapTime(str));
    }
}








//"0101"; //-> 1010 -> 1100
//"001011" -> 010011 -> 100011 -> 100101-> 101010 -> 110010->110100-> 111000 