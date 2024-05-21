package basic.backtracking;

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
        String str ="a1b2cd";
        int count=0;
        char[] arr=str.toLowerCase().toCharArray();
        List<List<String>> subset  = perm(str);
        for(List<String> ll: subset){
            System.out.println(ll.toString());
            count++;
        }
        System.out.println(count);
    }
    public static List<List<String>> perm(String S) {
        List<List<String>> list = new ArrayList<>();
        backTrack(list ,new ArrayList<>(), S.toCharArray(), 0);
        return list;
    }

    private static void backTrack (List<List<String>> list,List<String> temp ,  char[] s, int start ) {
        list.add(new ArrayList<>(temp));
        for (int i = start; i < s.length; i++) {
            if (Character.isAlphabetic(s[i])) {
                s[i] = (Character.isLowerCase(s[i])) ? Character.toUpperCase(s[i]) :
                        Character.toLowerCase(s[i]);
                temp.add(new String(s));
                backTrack(list,temp, s, i + 1);
                temp.remove(temp.size()-1);
            }
        }
    }
}
