package stack;

import java.util.Stack;

public class MinStack {
	Stack<Integer> mainStack = null;
	Stack<Integer> minStack = null;
	
	public MinStack() {
		mainStack = new Stack<>();
		minStack = new Stack<>();
    }
    
    public void push(int val) {
        mainStack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()) {
        	minStack.push(val);
        }
    }
    
    public void pop() {
        int val = mainStack.pop();
        
        if(val == minStack.peek()) {
        	minStack.pop();
        }
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
    
	public static void main(String a[]) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		minStack.getMin(); // return -3
		minStack.pop();
		minStack.top();    // return 0
		
		minStack.getMin(); // return -2
	}

}
