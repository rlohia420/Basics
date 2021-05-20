package basic.stackAndQueue;

public class SortStackUsingAnotherStack {

	public static Stack sortstack(Stack s) {
		Stack temp = new Stack();
		while(!temp.isEmplty()) {
			int current = s.pop();
			if(!temp.isEmplty() && temp.peek()>current) {
				s.push(temp.pop());
			}
			temp.push(current);
		}
		return temp;
	}
}
