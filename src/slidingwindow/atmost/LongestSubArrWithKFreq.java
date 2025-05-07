package slidingwindow.atmost;

import java.util.*;

public class LongestSubArrWithKFreq {
	
    public int maxSubarrayLength(int[] nums, int k) {
        return atMost(nums, k);
    }
    
    private int atMost(int[] nums, int k) {
    	if(k < 0) return 0;
    	
    	int left = 0;
    	int right = 0;
    	int maxLen = Integer.MIN_VALUE;
    	
    	Map<Integer, Integer> map = new HashMap<>();
    	
    	while(right < nums.length) {
    		int cur = nums[right];
    		
    		map.put(cur, map.getOrDefault(cur, 0) + 1);
    		
    		// shrink window when a number appears more times than 'k'
    		while(map.get(cur) > k) {
    			int lChar = nums[left];
    			map.put(lChar, map.get(lChar) - 1);
    			
    			if(map.get(lChar) == 0) {
    				map.remove(lChar);
    			}
    			left++;
    		}
    		
    		maxLen = Math.max(maxLen, right - left + 1);
    		right++;
    	}
    	return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
    
	public static void main(String[] args) {
		LongestSubArrWithKFreq ob = new LongestSubArrWithKFreq();

//		int[] nums = {1,2,3,1,2,3,1,2};
//		int k = 2;
//		Output: 6
		
//		int[] nums = {1,2,1,2,1,2,1,2};
//		int k = 1;
//		Output: 2
		
		int[] nums = {5,5,5,5,5,5,5};
		int k = 4;
//		Output: 4
		System.out.println(ob.maxSubarrayLength(nums, k));
	}

}
