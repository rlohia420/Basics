package basic.java8.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
	  public static void main(String args[]){
	       List<Integer> list = new ArrayList<>();
	       list.add(3);
	       list.add(2);
	       list.add(4);
	       list.add(6);
	       list.add(1);
	       Collections.sort(list);
	       //{1,2,3,4,5,6} -> n(a+l)/2 = 6(7/2) = 21 , n+1(n)/2;
	      System.out.println(list.stream().mapToInt(Integer::valueOf).sum());
	       //System.out.println((list.size()+1) * (list.get(0)+list.get(list.size()-1)) / 2 - list.stream().mapToInt(Integer::valueOf).sum());
	   }
	
}
