package leetcode.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortVowelsInAString_2785 {
    public static void main(String args[]){
        String str ="lYmpH";// "lEetcOde";
        StringBuilder sbr = new StringBuilder();
        char[] ch = str.toCharArray();
        int count=0;
        List<Character> list = new ArrayList<>();
        for(int i=0;i<ch.length;i++){
            char c = ch[i];
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'|| c=='A'||c=='E'||c=='I'||c=='O'||c=='U'){
                sbr.append(count);
                list.add(c);
                count++;
            }else{
                sbr.append(c);
            }
        }
        Collections.sort(list);
        String res = sbr.toString();
        for(int i=0;i<list.size();i++) {
            char c= Character.forDigit(i,10);
            res = res.replace(c, list.get(i));
        }
        System.out.println(res);
    }
}
