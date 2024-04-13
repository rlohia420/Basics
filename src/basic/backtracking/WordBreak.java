package backtracking;

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
    public static void wordBreak(int start , String str , List<String> res , Set<String> wordSet , List<String> tempList){
        if(start==str.length()){
            res.add(tempList.toString());
            return;
        }
        StringBuilder sbr = new StringBuilder();
        for(int i=start;i<str.length();i++){
            sbr.append(str.charAt(i));
            if(wordSet.contains(sbr.toString())){
                tempList.add(sbr.toString());
                wordBreak(i+1 , str, res , wordSet, tempList);
                tempList.remove(tempList.size() - 1);
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
