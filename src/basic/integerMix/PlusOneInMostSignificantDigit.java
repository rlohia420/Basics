package basic.integerMix;

public class PlusOneInMostSignificantDigit {
    public static void main(String args[]){
        int[] input = {9,3,10};
        for(int i=0;i<input.length;i++){
            System.out.println(input[i]);
        }
        int[] result = plusOne(input);
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
