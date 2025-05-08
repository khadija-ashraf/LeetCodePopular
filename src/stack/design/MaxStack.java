package stack.design;

import java.util.Stack;

public class MaxStack {
	private Stack<Integer> stack = null;
	private Stack<Integer> maxStack = null;
	
	public MaxStack() {
        stack = new Stack<Integer>();
        maxStack = new Stack<Integer>();
    }
    
    public void push(int val) {
    	stack.push(val);
        if(maxStack.isEmpty() || val >= maxStack.peek()) {
        	maxStack.push(val);
        }
    }
    
    public void pop() {
    	if(stack.peek() == maxStack.peek()) {
    		maxStack.pop();
    	}
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    public int getMax() {
        return maxStack.peek();
    }
    
    public static void main(String a[]) {
    	MaxStack ob = new MaxStack();
    	
    	// 5,3,8,1,33, 9, 4
    	ob.push(8);
    	ob.push(3);
    	ob.push(5);
    	ob.push(1);
    	ob.push(9);
    	ob.push(10);
    	ob.push(33);
    	ob.push(22);
    	
    	System.out.println(ob.maxStack);
    	System.out.println(ob.stack);

    	ob.pop();
    	
    	ob.pop();
    	
    	System.out.println(ob.top());
    	
    	System.out.println(ob.peekMax());
    	
    	System.out.println(ob.getMax());
    	
    	System.out.println(ob.maxStack);
    	
    }
}
