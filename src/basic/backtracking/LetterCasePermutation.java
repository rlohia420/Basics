package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

   /* public static void main(String args[]){
        String str = "a1b2";
        List<String> list = letterCase(str);
        for(String s: list){
            System.out.println(s);
        }
    }
    private static List<String> letterCase(String str){
        List<String> ans = new ArrayList<>();
        dfs(str.toLowerCase().toCharArray() , ans , 0 , str.length());
        return ans;
    }
    private static void dfs(char[] ch , List<String> ans , int i , int len){
        if(i==len)
            ans.add(new String(ch));
        else{
            dfs(ch , ans , i+1, len);
            if(Character.isLetter(ch[i])){
                ch[i] = Character.toUpperCase(ch[i]);
                dfs(ch,ans,i+1,len);
                ch[i] = Character.toLowerCase(ch[i]);
            }
        }
    }*/
   private static List<String> ans;
    public static List<String> letterCasePermutation(String S) {
        ans = new ArrayList<>();
        ans.add(S);
        dfs(S.toCharArray(), 0);
        return ans;
    }

    private static void dfs ( char[] s, int index ) {
        for ( int i = index; i < s.length; i++ ) {
            if ( Character.isAlphabetic(s[i]) ) {
                char temp = s[i];
                s[i] = ( Character.isLowerCase(s[i]) )? Character.toUpperCase(s[i]) :
                        Character.toLowerCase(s[i]);
                ans.add( new String(s) );
                dfs( s, i+1 );
                s[i] = temp;
            }
        }
    }


    public static void main(String args[]){
        String str ="a1b2";
        int count=0;
        char[] arr=str.toLowerCase().toCharArray();
        List<String> subset  = letterCasePermutation(str);
        for(String ll: subset){
            System.out.println(ll.toString());
            count++;
        }
        System.out.println(count);
    }

}
