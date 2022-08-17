package basic.stackAndQueue;

public class StackWithMinValue extends Stack {

	Stack min = new Stack();
	
	public void push(int x) {
		if(isEmpty()) {
			super.push(x);
			min.push(x);
		}else {
			int y = min.pop();
			min.push(y);
			if(x<y) {
				min.push(x);
			}else {
				min.push(y);
			}
		}
	}
	
	public int pop() {
		int y = super.pop();
		min.pop();
		return y;
	}
	public int getMin() {
		int x = min.pop();
		min.push(x);
		return x;
	}
	public static void main(String[] args)
    {
		StackWithMinValue s = new StackWithMinValue();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.getMin());
        s.push(5);
        System.out.println(s.getMin());
    }
}
