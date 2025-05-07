package slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class ContinuousSubArray {
	
//	To find the number of subarrays in an array of n elements, use this formula:
//	n*(n+1)/2
	
//	To find the number of subsets from a set with n elements, you use the formula:
//	Number of subsets = 2^n
    public long continuousSubarrays(int[] nums) {
    	long count = 0;
    	int left = 0;
    	int right = 0;
    	
    	Deque<Integer> minDeq = new ArrayDeque<>();
    	Deque<Integer> maxDeq = new ArrayDeque<>();
    	
    	while(right < nums.length) {
    		int curr = nums[right];
    		
    		while(!minDeq.isEmpty() && curr < minDeq.peekLast()) {
    			minDeq.pollLast();
    		}
    		
    		minDeq.offerLast(curr);
    		
    		while(!maxDeq.isEmpty() && curr > maxDeq.peekLast()) {
    			maxDeq.pollLast();
    		}
    		
    		maxDeq.offerLast(curr);
    		
            // Shrink window if the condition is violated
    		while(maxDeq.peekFirst() - minDeq.peekFirst() > 2) {
    			if(minDeq.peekFirst() == nums[left]) {
    				minDeq.pollFirst();
    			}
    			
    			if(maxDeq.peekFirst() == nums[left]) {
    				maxDeq.pollFirst();
    			}
    			left++;
    		}
            // Count the subarrays ending at 'right'
			count += right-left+1;
			right++;
    	}
    	return count;
    }
	
	
	// this version does not work. because we need to check 
	// if the max - min of any window must be <= 2.
	// so we need to keep track of the max, and min of a window.
	// in this version we are not keeping the max, min tracking. 
    public long continuousSubarrays1(int[] nums) {
        long count = 0;
        int start = 0;
        int end = 0;
        for(start = 0; start < nums.length; start++) {
        	for(end = start; end < nums.length; end++) {
        		long absolute = Math.abs(nums[start] - nums[end]);
        		if(absolute > 2) {
        			break;
        		}
        	}
    		count += end - start;
        }
        return count;
    }
    
	public static void main(String[] args) {
		ContinuousSubArray ob = new ContinuousSubArray();
//		int[] nums = {5,4,2,4};
//		Output: 8
		
//		int[] nums = {1,2,3};
//		Output: 6
		int[] nums = {65,66,67,66,66,65,64,65,65,64};
//		Output: 43
		System.out.println(ob.continuousSubarrays(nums));
	}

}
