package hashtable.detectDuplicate;

import java.util.*;

public class ContainsDuplicate3 {
	public boolean containsNearbyAlmostDuplicate(int[] nums, 
			int indexDiff, int valueDiff) {
		
		if(indexDiff < 1 || indexDiff > nums.length) return false;
		
		TreeSet<Integer> window = new TreeSet<>();	// window of size indexDiff

		int left = 0;
		for(int i = 0; i < nums.length; i++) {
			
			int lowerBoundery = nums[i] - valueDiff;
			int upperBoundary = nums[i] + valueDiff;
			
			Integer num_j = window.ceiling(lowerBoundery);
			
			// there is at least one item in the window that 
			// is >= lowerbounday <= upperbounday. 
			// so the current num[i] is in the range of the valueDiff 
			// with another item num[j] in the window.
			if(num_j != null 
					&& num_j >= lowerBoundery
					&& num_j <= upperBoundary) {
				return true;
			}
			window.add(nums[i]);
			
			while(window.size() > indexDiff) {
				window.remove(nums[left]);
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
