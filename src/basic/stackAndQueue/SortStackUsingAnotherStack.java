package basic.stackAndQueue;

public class SortStackUsingAnotherStack {

	public static Stack sortstack(Stack s) {
		Stack temp = new Stack();
		while(!s.isEmpty()) {
			int current = s.pop();
			while(!temp.isEmpty() && temp.peek()>current) {
				s.push(temp.pop());
			}
			temp.push(current);
		}
		return temp;
	}
	public static void main(String args[]) {
		Stack s = new Stack();
		s.push(20);
		s.push(22);
		s.push(30);
		s.push(25);	
		s.push(21);
		Stack t = sortstack(s);
		while(!t.isEmpty()) {
			System.out.println(t.pop());
		}
	}
}
