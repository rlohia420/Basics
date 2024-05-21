package basic.backtracking;

import java.util.*;

public class WordBreak {
    public static  void wordBreak(String str , String[] words){
        Set<String> wordSet = new HashSet(Arrays.asList(words));
        List<String> res = new ArrayList<>();
        wordBreak(0,str , res ,wordSet, new ArrayList<>());
        for(String ss: res){
            System.out.println(ss);
        }
    }
    public static void wordBreak(int start , String str , List<String> list , Set<String> dic , List<String> temp){
        if(start==str.length()){
            list.add(temp.toString());
            //return;
        }else {
            StringBuilder sbr = new StringBuilder();
            for (int i = start; i < str.length(); i++) {
                sbr.append(str.charAt(i));
                if (dic.contains(sbr.toString())) {
                    temp.add(sbr.toString());
                    wordBreak(i + 1, str, list, dic, temp);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
    public static void main(String args[]){
        String str = "catsanddog" ; String[] words = {"cat","cats","and","sand","dog","dogs"};
        wordBreak(str , words);

        String str1 = "NEHALOHIAPRATEEK" ; String[] words1 = {"NEHA", "PRATEEK", "LOHIA" , "LOHIAP" , "RATEEK", "NEH"};
        wordBreak(str1, words1);
    }
}
