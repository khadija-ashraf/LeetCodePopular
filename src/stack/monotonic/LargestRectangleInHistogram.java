package stack.monotonic;

import java.util.*;

public class LargestRectangleInHistogram {
//	- What Is a Monotonic Stack?
//	A monotonic stack is a stack that is either:
//		•	Increasing → each new element is larger than or equal to the one below it.
//		•	Decreasing → each new element is smaller than or equal to the one below it.
//
//	The Intuition:
//	You’re building a stack of books from smallest to largest.
//		•	You start with a small book.
//		•	If the next book is taller, you can safely stack it.
//		•	But if the next book is shorter, it doesn’t fit the pattern. So you:
//		•	Remove taller books (pop from the stack)
//		•	Then try to place the smaller one.
//
//	This helps you track the nearest smaller book to the left for each book.
//
//	For “Largest Rectangle in Histogram” (Increasing Stack):
//		•	As long as heights are increasing, we push their indices to the stack.
//		•	When we see a smaller height, we:
//		•	Pop until the height condition is restored.
//		•	Each popped bar represents a rectangle.
//		•	You calculate the width using the distance between the current index
//	        and the last element in the stack (left bound).
//		•	You compute area and track the max.
//
//	Analogy:
//	You’re walking through bars (buildings). When a shorter building appears, it’s time to settle the rectangles that were waiting for a taller ending.
//
//	- Why This Works?
//		•	You’re breaking the problem into smaller subproblems: for each height, find how far it can extend to the left and right.
//		•	The stack helps store only useful candidates.
//		•	This gives you constant-time access to previous valid bounds.

//	We don’t need to explicitly compute min(height[i..j]) because:
//		•	The monotonic stack structure makes sure that each height we pop is the minimum in the current window.
//		•	The window is bounded by indices with smaller height, which we find using the stack.

	public int largestRectangleArea(int[] heights) {
	    Stack<Integer> stack = new Stack<>(); // monotonic increasing stack. we will keep 
	    									 // increasing values only, if any smaller value
	    									 // comes we will pop from the stack until the 
	    									 // stack.top() is smaller than the current val.
	    int maxArea = 0;
	    int n = heights.length;

	    for (int i = 0; i <= n; i++) {
	        int currHeight = (i == n) ? 0 : heights[i]; // Sentinel bar at the end

	        // keep popping
	        while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
	            int height = heights[stack.pop()];
	            int width = 0;
	            if(stack.isEmpty()) {
	            	width = i;
	            } else {
	            	width = (i-1) - (stack.peek() + 1) + 1; 
	            }
	            maxArea = Math.max(maxArea, height * width);
	        }
	        // now the stack top is smaller than this current val 'currHeight'. so push
	        stack.push(i); // pushing all increasing value-indices, if any decreasing value 
	        				// comes we start popping larger values from the stack 
	        				// until we can accommodate this current smaller value in the stack.
	    }
	    return maxArea;
	}
    
    public static void main(String a[]) {
    	LargestRectangleInHistogram ob = new LargestRectangleInHistogram();
    	int[] heights = {2, 1, 5, 60, 2, 3};
//		Output: 10
    	
//    	int[] heights = {1, 1};
//		Output: 2
    	
//    	ob.largestRectangleArea(heights);
    	System.out.println(ob.largestRectangleArea(heights));
    }
    
	public int largestRectangleArea1(int[] heights) {
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
	            	 System.out.println(width);
	            } else {
//	            	Case 2: !stack.isEmpty()
//
//	            	This means:
//	            		•	There is a smaller bar to the left, and its index is stack.peek().
//	            		•	So the rectangle starts right after that, at stack.peek() + 1, and ends at i - 1.
//	            		•	Hence, width = i - stack.peek() - 1
	            	width = (i-1) - (stack.peek() + 1) + 1; // reduced to below line.
	            	 System.out.println(width);
	            	//width = i - stack.peek() - 1;
	            	
//	            	•	The stack helps find boundaries (previous smaller and next smaller).
//	            	•	When popping, the bar you’re evaluating spans from:
//	            	•	Left: just after the last smaller bar (stack.peek())
//	            	•	Right: current index i (where a smaller bar is found)
//
//	            So, i - stack.peek() - 1 is the accurate width of that rectangle.
//	            	•	Left boundary = last smaller bar before h[i] (which is stored in the stack)
//	            	•	Right boundary = current index i (the smaller bar we’re seeing now)
//	            	Visual Example

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

}
