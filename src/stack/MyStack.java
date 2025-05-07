package stack;

import java.util.Queue;
import java.util.LinkedList;


class MyStack {

	Queue<Integer> queue = null;
	
    public MyStack() {
    	queue = new LinkedList<>();
    }
    
    public void push(int x) {
    	// insert at the end of the queue
        queue.offer(x);
       
        //now rotate the queue until the latest added value.
        // so the latest value will come forward gradually and sit at the 
        // front. and the previous values starting from the fron will sit after the
        // latest one.
        // queue = [1,2,3,4], latest = 5
        // queue = [1,2,3,4,5] : inserted at the end
        // queue = [2,3,4,5,1] : rotating, one value at a time
        // queue = [3,4,5,1,2] : rotating, one value at a time
        // queue = [4,5,1,2,3] : rotating, one value at a time
        // queue = [5,1,2,3,4] : rotating, final
        
        for(int i = 0; i < queue.size() - 1; i++) {
        	queue.offer(queue.poll());
        }
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
    	return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
    
    public static void main(String a[]) {
    	
		 MyStack obj = new MyStack();
		 obj.push(1);
		 obj.push(2);
		 int param_2 = obj.pop();
		 int param_3 = obj.top();
		 boolean param_4 = obj.empty();
    }
}
