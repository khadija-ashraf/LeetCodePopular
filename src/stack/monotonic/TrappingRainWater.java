package stack.monotonic;

import java.util.Stack;

public class TrappingRainWater {
    
    public int trapBruteForce(int[] height) {
        int water = 0;
        for(int i = 0; i < height.length; i++) {
        	//for every bar i
        	// find the maxBar to the left of i, from i to 0 
        	int leftMax = 0;
        	for(int j = i; j >= 0; j--) {
        		leftMax = Math.max(leftMax, height[j]);
        	}
        	//find the maxBar to the right of i, from i to n-1
        	int rightMax = 0;
        	for(int j = i; j < height.length; j++) {
        		rightMax = Math.max(rightMax, height[j]);
        	}
        	water += Math.min(leftMax, rightMax) - height[i];
        }
        return water;
    }
    
    public int trapMemory(int[] height) {
        int water = 0;
        int n = height.length;
        
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        int max = 0;
        for(int i = 0; i < n; i++) {
        	max = Math.max(max, height[i]);
        	leftMax[i] = max;
        }
        
        max = 0;
        for(int i = n - 1; i >= 0 ; i--) {
        	max = Math.max(max, height[i]);
        	rightMax[i] = max;
        }
        
        for(int i = 0; i < n; i++) {
        	water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return water;
    }
    
    public int trapConstantSpace(int[] height) {
    	int leftMax = 0;
    	int rightMax = 0;
    	int left = 0;
    	int right = height.length -1;
    	int water = 0;
    	
    	while(left < right) {
    		if(height[left] < height[right]) {
    			if(height[left] > leftMax) {
    				leftMax = height[left];
    			} else {
    				water += leftMax - height[left];
    			}
    			left++;
    		} else {
    			if(height[right] > rightMax) {
    				rightMax = height[right];
    			} else {
    				water += rightMax - height[right];
    			}
    			right--;
    		}
    	}
    	return water;
    }

//	Stack Intuition
//	We process the elevation map left to right, using a stack of indices. 
//  The stack helps us remember the bars that are yet to find a right boundary.
//	We push bars onto the stack as long as the height decreases or 
//  stays the same (maintaining a monotonic decreasing stack).
//	What happens when we find a taller bar?
//	Imagine the current bar is taller than the bar on top of the stack. That means:
//		•	The bar at the top of the stack is a valley (bottom of a water container).
//		•	The current bar is the right wall.
//		•	The next element in the stack (after popping the valley) is the left wall.
    

    public int trapStack(int[] height) {
        int water = 0;
        int n = height.length;
        
        // stack of indices. This stack holds higher bars. 
        // meaning when we find a taller bar than
        // the previous bar we know that a valley might be
        // formed and the taller bar is a boundary(left / right) 
        Stack<Integer> stack = new Stack<>(); 
        
        for(int i = 0; i < n; i++) {
        	int curHeight = height[i];
        	// when we found a higher bar we know a valley might be formed. 
        	// the higher bar is the right boundary of the valley
        	while(!stack.isEmpty() && curHeight > height[stack.peek()]) {
        		int bottom = stack.pop(); // valley 
        		
        		if(stack.isEmpty()) break; // no left boundary exists. 
        		
        		int leftBoundary = stack.peek();
        		int rightBoundary = i;
        		
        		// width of the valley
        		int valleyWidth = (rightBoundary - 1) - (leftBoundary + 1) + 1;
        		
        		int valleyHeight = Math.min(height[leftBoundary], height[rightBoundary])
        				- height[bottom];
        		
        		water += valleyHeight * valleyWidth;
        	}
        	stack.push(i);
        }
        return water;
    }
    
	public static void main(String[] args) {
		TrappingRainWater ob = new TrappingRainWater();
		
//		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
//		leftMax		 = {0,1,1,2,2}
//		Output: 6
		
		int[] height = {4,2,0,3,2,5};
//		Output: 9
		System.out.println(ob.trapBruteForce(height));
		System.out.println(ob.trapMemory(height));
		System.out.println(ob.trapConstantSpace(height));
		System.out.println(ob.trapStack(height));
		

	}

}
