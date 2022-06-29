package basic.stackAndQueue;

public class SortStackUsingAnotherStack {

	public static Stack sortstack(Stack s) {
		Stack temp = new Stack();
		while(!s.isEmpty()) {
			int current = s.pop();
			if(!temp.isEmpty() && temp.peek()>current) {
				s.push(temp.pop());
			}
			temp.push(current);
		}
		return temp;
	}
}
