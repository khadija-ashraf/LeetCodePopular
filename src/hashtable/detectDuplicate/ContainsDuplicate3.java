package hashtable.detectDuplicate;

import java.util.*;

public class ContainsDuplicate3 {
	public boolean containsNearbyAlmostDuplicate(int[] nums, 
			int indexDiff, int valueDiff) {
		
		if(indexDiff < 1 || indexDiff > nums.length) return false;
		
		int left = 0;
		
		TreeSet<Integer> treeset = new TreeSet<>();	// window of size indexDiff
		// we are using treeset because, all the elements in this 
		// set are sorted. so we can search a num by range.
		
		for(int right = 0; right < nums.length; right++) {
			int cur = nums[right];
			
			//[cur - valueDiff, cur + valueDiff] 
			int lowerBoundery = cur - valueDiff;
			int upperBoundary = cur + valueDiff;
			
//			abs(nums[i] - nums[j]) <= valueDiff
			
			// we can re-write the Math.abs() function like below,
			
//			nums[i] - nums[j] <= valueDiff  => nums[i] - valueDiff <= nums[j]
//			nums[j] - nums[i] <= valueDiff =>  nums[i] - valueDiff >= nums[j]
			
			
			// this nums[i] is the current num and the nums[j] is a num
			// already in the window(treeset). 
			
			
			
			if(!treeset.isEmpty()) {
				Integer justgrater = treeset.ceiling(lowerBoundery);
				
				// there is at least one item in the window that 
				// is >= lowerbounday <= upperbounday. 
				// so the current num is in the range of the valueDiff 
				// with another item in the window.
				if(justgrater != null 
						&& justgrater >= lowerBoundery
						&& justgrater <= upperBoundary) {
					return true;
				}
			}
			treeset.add(cur);
			
			while(treeset.size() > indexDiff) {
				treeset.remove(nums[left]);
				left++;
			}

			
		}
		return false;
	}
	
	

	public static void main(String[] args) {
		ContainsDuplicate3 ob = new ContainsDuplicate3();
		
//		int[] nums = {1,2,3,1};
//		int indexDiff = 3;
//		int valueDiff = 0;
		
//		1,2,3 = |2-1| = 1, |3-1| = 2, |2-3| = 1
		// 2, 3, 1
//		Output: true
		
//		int[] nums = {1,5,9,1,5,9};
//		int indexDiff = 2;
//		int valueDiff = 3;
//		Output: false
		
//		int[] nums = {1,0,1,1};
//		int indexDiff = 1;
//		int valueDiff = 2;
//		Output: true

		int[] nums = {-2,3};
		int indexDiff = 2;
		int valueDiff = 5;
//		Output: true

		System.out.println(ob.containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff));

	}

}
