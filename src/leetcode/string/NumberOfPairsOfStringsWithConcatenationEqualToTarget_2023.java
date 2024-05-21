package leetcode.string;

public class NumberOfPairsOfStringsWithConcatenationEqualToTarget_2023 {
    public static void main(String args[]){
       String[] nums = {"123","4","12","34"}; String target = "1234";
       int count=0;
       for(int i=0;i<nums.length;i++){
           for(int j=0;j<nums.length;j++){
               if(i!=j && nums[i].length() + nums[j].length() == target.length() ){
                   if((nums[i]+nums[j]).equals(target)){
                       count++;
                   }
               }
           }
       }
       System.out.println(count);

    }
}
