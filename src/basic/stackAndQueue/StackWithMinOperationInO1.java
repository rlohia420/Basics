package basic.stackAndQueue;

public class StackWithMinOperationInO1 {
/*
 *  Java program to implement a stack that supports getMinimum() in O(1) time and O(1) extra space
 *  https://www.youtube.com/watch?v=ZvaRHYYI0-4
 */
	Stack s;
    Integer minEle;
  
    StackWithMinOperationInO1() { s = new Stack(); }
  
    void getMin()
    {
        if (s.isEmpty())
            System.out.println("Stack is empty");
        else
            System.out.println("Minimum Element in the stack is: " + minEle);
    }
  
    // prints top element of MyStack
    public int peek(){
        if (s.isEmpty()){
            System.out.println("Stack is empty ");
            return 0;
        }
  
        Integer t = s.peek(); // Top element.
        System.out.print("Top Most Element is: ");
        if (t < minEle) {
            System.out.println(minEle);
            return minEle;
        }
        else {
            System.out.println(t);
            return t;
        }
    }
  
    public int pop(){
    	int top =0;
        if (s.isEmpty()){
            System.out.println("Stack is empty");
            return top;
        }
        System.out.print("Top Most Element Removed: ");
        Integer t = s.pop();
        if (t < minEle){
            System.out.println(minEle);
            top = minEle;
            minEle = 2*minEle - t;
            return top;
        }
        else
            System.out.println(t);
        return t;
    }
  
    void push(Integer x){
        if (s.isEmpty()){
            minEle = x;
            s.push(x);
            System.out.println("Number Inserted: " + x);
            return;
        }
        if (x < minEle){
            s.push(2*x - minEle);
            minEle = x;
        }
        else
            s.push(x);
        System.out.println("Number Inserted: " + x);
    }
    public static void main(String[] args)
    {
    	StackWithMinOperationInO1 s = new StackWithMinOperationInO1();
        s.push(3);
        s.push(5);
        s.getMin();
        s.push(2);
        s.push(1);
        s.getMin();
        s.pop();
        s.getMin();
        s.pop();
        s.peek();
    }
}
