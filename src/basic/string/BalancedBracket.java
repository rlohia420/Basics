package basic.string;

import java.io.IOException;
import java.util.Stack;

public class BalancedBracket {
	public static void main(String args[]) throws IOException {
		System.out.println(isBalance("[NEHA{LOHIA}PRATEEK]"));
	}
	private static boolean isBalance(String string) {
		{
			Stack<Character> stack = new Stack<Character>();
		    String newExp = string;
		    for (int i = 0; i < newExp.length(); i++)
		    { 
		      char ch = newExp.charAt(i);
		      if (ch == '(' || ch == '[' || ch == '{')
		        stack.push(ch);
		      else if (ch == ')'|| ch == ']' || ch == '}')
		      {
		    	  Character ch1 = null;
		    	  if(ch==')') {
		    		  ch1='(';
		    	  }else if(ch=='}') {
		    		  ch1='{';
		    	  }else if(ch==']') {
		    		  ch1='[';
		    	  }
		        if(stack.isEmpty())
		        {  
		          return false;
		        }
		        else if(stack.pop() == ch1)
		        { 
		        	continue;
		        } else {
		        	return false;
		        }

		      }            
		    }
		    if (stack.isEmpty())
		    {
		      return true;
		    }
		    else
		    {
		      return false;
		    }
		}
	}
}
