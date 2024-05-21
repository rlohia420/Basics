package leetcode.string;

public class CountSortedVowelString_1641 {
    public static int countVowelStrings(int n) {
        int a=1,e=1,i=1,o=1,u=1;
        for(int k=1;k<n;k++){
            a=a+e+i+o+u;
            e=e+i+o+u;
            i=i+o+u;
            o=o+u;
        }
        return a+e+i+o+u;
    }
    public static void main(String args[]){
        System.out.println(countVowelStrings(2));
        /*
        aa , ae , ai , ao, au , ee ,ei , eo ,eu , ii , io , iu , oo ,ou ,uu
         */
    }
}
