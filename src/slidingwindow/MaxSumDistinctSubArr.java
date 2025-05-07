package slidingwindow;

import java.util.*;

public class MaxSumDistinctSubArr {
    public long maximumSubarraySum(int[] nums, int k) {
        
    	int left = 0;
    	long max = 0;
    	Set<Integer> set = new HashSet<>();
    	long sum = 0;
    	
    	for(int right = 0; right < nums.length; right++) {
    		// expand to right
    		int current = nums[right];
    		
    		while(set.contains(current)) {
    			set.remove(nums[left]);
    			sum -= nums[left];
    			left++;
    		}
    		
			sum += current;
			set.add(current);
    		
    		if(right-left+1 == k) {
				max = Math.max(max, sum);
    			
				set.remove(nums[left]);
    			sum -= nums[left];
    			left++;
    		}
    	}
    	return max;
    }
    
	public static void main(String[] args) {
		MaxSumDistinctSubArr ob = new MaxSumDistinctSubArr();
		
//		int[] nums = {1,5,4,2,9,9,9};
//		int k = 3;
//		Output: 15
		
//		int[] nums = {4,4,4};
//		int k = 3;
//		Output: 0
		
		int[] nums = {1,1,1,7,8,9};
		int k = 3;
//		Output: 24
		

		System.out.println(ob.maximumSubarraySum(nums, k));
	}
}
