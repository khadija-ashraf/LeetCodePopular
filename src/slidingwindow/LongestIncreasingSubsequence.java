package slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
    	// monotonic queue- increasing order
    	// this deque is the window - its holding indices
        Deque<Integer> deque = new ArrayDeque<>();
        int maxLen = 0;
        
        for(int right = 0; right < nums.length; right++) {
        	
        	// shrink the if bigger element is sitting in last of the dequq
        	while(!deque.isEmpty() && nums[right] <= nums[deque.peekLast()]) {
        		deque.pollLast();
        	}
        	
        	// now that all the bigger items are removed from the end of the deque
        	// we can add our current element
        	deque.offerLast(right);
        	
        	//update the window size
        	maxLen = Math.max(maxLen, deque.size());
        	System.out.println("maxLen: "+maxLen);
        	print(deque, nums);
        }
        return maxLen;
    }
    private void print(Deque<Integer> deque, int[] nums) {
    	if(deque == null) return;
    	
    	for(int n: deque) {
    		System.out.print(nums[n] +", ");
    	}
    	System.out.println();
    }
	public static void main(String[] args) {
		LongestIncreasingSubsequence ob = new LongestIncreasingSubsequence();
//		int[] nums = {10,9,2,5,3,7,101,18};
//		Output: 4

//		int[] nums = {7,7,7,7,7,7,7};
//		Output: 1
		
		int[] nums = {0,1,0,3,2,3};
//		Output: 4
		System.out.println(ob.lengthOfLIS(nums));
	}

}
