package stack.monotonic;

import java.util.*;

public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] heights) {
	    Stack<Integer> stack = new Stack<>();
	    int maxArea = 0;
	    int n = heights.length;

	    for (int i = 0; i <= n; i++) {
	        int currHeight = (i == n) ? 0 : heights[i]; // Sentinel bar at the end

	        while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
	            int height = heights[stack.pop()];
	            int width = 0;
//	        	•	If the stack is empty, the popped bar extended all the way to the beginning.
//	        	•	Else, it extended from the bar after the previous one in the stack.
	            if(stack.isEmpty()) {
//	            	Case 1: stack.isEmpty()
//
//	            	This means:
//	            		•	There is no smaller bar to the left of top.
//	            		•	So the rectangle can extend all the way from index 0 to i-1.
//	            		•	Hence, width = i

	            	width = i;
	            } else {
//	            	Case 2: !stack.isEmpty()
//
//	            	This means:
//	            		•	There is a smaller bar to the left, and its index is stack.peek().
//	            		•	So the rectangle starts right after that, at stack.peek() + 1, and ends at i - 1.
//	            		•	Hence, width = i - stack.peek() - 1
	            	width = (i-1) - (stack.peek() + 1) + 1; // reduced to below line.
//	            	 
	            	//width = i - stack.peek() - 1;
	            	
//	            	•	The stack helps find boundaries (previous smaller and next smaller).
//	            	•	When popping, the bar you’re evaluating spans from:
//	            	•	Left: just after the last smaller bar (stack.peek())
//	            	•	Right: current index i (where a smaller bar is found)
//
//	            So, i - stack.peek() - 1 is the accurate width of that rectangle.
//	            	•	Left boundary = last smaller bar before h[i] (which is stored in the stack)
//	            	•	Right boundary = current index i (the smaller bar we’re seeing now)
//	            	📐 Visual Example

//	            	Say you have: [2, 1, 5, 6, 2, 3]
//	            		•	When you’re at 5 and 6, you wait because you think maybe a taller or equal bar is coming.
//	            		•	But when you hit 2, which is less than both 5 and 6, you pop them and calculate their areas — because now you’ve found their right boundary.
	            }
	            maxArea = Math.max(maxArea, height * width);
	        }
	        stack.push(i);
	    }
	    return maxArea;
	}
    
    public static void main(String a[]) {
    	LargestRectangleInHistogram ob = new LargestRectangleInHistogram();
//    	int[] heights = {2, 1, 5, 6, 2, 3};
//		Output: 10
    	
    	int[] heights = {1, 1};
//		Output: 2
    	
    	
    	System.out.println(ob.largestRectangleArea(heights));
    }
}
