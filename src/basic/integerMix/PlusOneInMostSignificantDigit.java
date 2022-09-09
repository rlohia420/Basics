package basic.integerMix;

public class PlusOneInMostSignificantDigit {
    public static void main(String args[]){
    	int x = 234;
    	String temp = Integer.toString(x);
    	int[] newGuess = new int[temp.length()];
    	for (int i = 0; i < temp.length(); i++)
    	{
    	    newGuess[i] = temp.charAt(i) - '0';
    	}
        int[] input = {9,3,9};
        for(int i=0;i<input.length;i++){
            System.out.print(input[i]+"-");
        }
        System.out.println();
        int[] result = plusOne(newGuess);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i] +"-");
        }
    }
    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        int incrementNum = digits[len-1];
        int[] output = null;
        if(digits[len-1]==9){
            output = new int[len+1];
        }else{
            output = new int[len];
        }
        for(int i=0;i<=len-1;i++){
            if(i!=len-1)
                output[i]=digits[i];
            else{
                if(digits[i]==9){
                    output[i]= 1;
                    output[i+1]=0;
                }else{
                    output[i] = incrementNum+1;
                }
            }

        }
        return output;
    }
}
