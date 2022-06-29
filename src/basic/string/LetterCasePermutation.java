package basic.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LetterCasePermutation {

	public static void main(String args[]) {
		String str = "a1b2c";
		List<String> l = letterCasePermutation(str);		
		for(String s:l) {
			System.out.println(s);
		}
		
	}

	public static List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        
        helper(result, s, 0, new StringBuilder());
        
        return result;
    }
    
    private static void helper(List<String> result, String str, int idx, StringBuilder sb){
        // base case
        if(sb.length() == str.length()){
            result.add(sb.toString());
            return;
        }
        
        // logic
        char ch = Character.toLowerCase(str.charAt(idx));
        
        // case1 - handling lowercase & digit.
        sb.append(ch);
        helper(result, str, idx+1, sb);
        sb.deleteCharAt(sb.length()-1);
        
        // case2 - hadling uppercase only if the char is letter.
        if(Character.isLetter(ch)){
            ch = Character.toUpperCase(ch);
            sb.append(ch);
            helper(result, str, idx+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
