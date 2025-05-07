package slidingwindow;

import java.util.*;

public class SlidingWindowMaximum {

	public int[] maxSlidingWindow(int[] nums, int k) {
    	// stores indices of a window of nums variable
    	// we implement this deque decreasing order, so all bigger values
    	// will be at the front and smaller values will be at the later positions.
    	// the deque.peekFirst() will always return the max.
    	Deque<Integer> deque = new ArrayDeque<>();
    	
    	int[] res = new int[nums.length - k + 1];
    	
    	for(int right = 0; right < nums.length; right++) {
    		// remove indices outside the window range
    		while(!deque.isEmpty() && deque.peekFirst() <= right - k) {
    			deque.pollFirst();
    		}
    		
    		// remove min values from the end, cause they will never be a max.
    		// before adding an element from the rear end to deque we ensure
    		// any smaller element siting in the queue got removed. keep removing
    		// elements from the rear until we find a bigger element than our 
    		// current one, or the deque is empty. Only then we add our current element 
    		
    		while(!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
    			deque.pollLast();
    		}
    		
    		// now we add our current element
    		deque.add(right);
    		
    		// now we add the front element to the deque because this represents the 
    		// max of the current window, before that check if a valid window formed of
    		// size 'k' yet. Cause at the begining the window size will grow from 0 to k
    		
    		if(right >= k - 1) {
    			res[right - k + 1] = nums[deque.peekFirst()];
    		}
    		
    	}
    	return res;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
