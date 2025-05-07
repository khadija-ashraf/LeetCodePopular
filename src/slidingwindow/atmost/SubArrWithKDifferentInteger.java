package slidingwindow.atmost;

import java.util.*;

public class SubArrWithKDifferentInteger {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    
    private int atMost(int[] nums, int k) {
    	if(k < 0) return 0;
    	
    	int left = 0;
    	int right = 0;
    	
    	int count = 0;
    	Map<Integer, Integer> map = new HashMap<>();
    	
    	while(right < nums.length) {
    		//expand the window
    		int cur = nums[right];
    		map.put(cur, map.getOrDefault(cur, 0) + 1);
    		
    		if(map.get(cur) == 1) { // this is a unique num
    			k--;
    		}

    		// shrink the window until the prev value gets trimmed 
    		// so that the new value 
    		// gets a spot to enter in the window
    		while(k < 0) {
    			int lNum = nums[left];
    			map.put(lNum, map.getOrDefault(lNum, 0) - 1);
    			
    			if(map.get(lNum) == 0) {
    				map.remove(lNum);
    				k++;
    			}
    			left++;
    		}
    		
    		// now that the window is of <= k number of distinct elements
    		// so update the result
    		count += right - left + 1;
    		right++;
    	}
    	return count;
    }
	public static void main(String[] args) {
		SubArrWithKDifferentInteger ob = new SubArrWithKDifferentInteger();
//		int[] nums = {1,2,1,2,3};
//		int k = 2;
//		Output: 7
		
		int[] nums = {1,2,1,3,4};
		int k = 3;
//		Output: 3
		
//		Explanation: Subarrays formed with exactly 2 different 
//		integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
		
		System.out.println(ob.subarraysWithKDistinct(nums, k));
		
	}

}
