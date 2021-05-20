package basic.stackAndQueue;

import java.util.LinkedList;

public class StackImplementationUsing2Queue {

	LinkedList q1;
	LinkedList q2;
	StackImplementationUsing2Queue(){
		q1=new LinkedList();
		q2=new LinkedList();
	}
	public void push(int value) {
		if(q1.size()==0) {
			q1.add(value);
		}else {
			for(int i=0;i<q1.size();i++) {
				q2.add(q1.remove());
			}
			q1.add(value);
		}
		for(int i=0;i<q1.size();i++) {
			q1.add(q2.remove());
		}
	}
	public int pop() {
		if(q1.size()==0) {
			System.out.println("empty");
		}
		return (int) q1.remove();
	}
}
